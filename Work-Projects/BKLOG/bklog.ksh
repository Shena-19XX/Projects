#!/bin/ksh
#######################################################################
# 11/27/2023 CO XXXXXX  Shena J.	Split sendclmsBklog Emails
#######################################################################

. job_begin.ksh

CONFIG_FILE=$DATADIR/clmBackLogSendclms.config
OUTPUT_FILE=$TMPDIR/sendclmsENCBklog_email
TEMP_FILE=$TMPDIR/sendclmsENCBklog_temp

emailTo1=`grep '^emailTo1' $CONFIG_FILE | awk -F= 'NR == 1{print $2}'`
AlertENC=`grep '^AlertENC' $CONFIG_FILE | awk -F= 'NR == 1{print $2}'`

echo Ecounter Claims >> $OUTPUT_FILE
clmpecnt -p $DATADIR/encounters/input/`date +%Y%m%d` > $TEMP_FILE
cat $TEMP_FILE >> $OUTPUT_FILE

totalENC=$(grep "Grand Totals" $TEMP_FILE | awk '{print $3}')

## send backlog information to email list on config file
if [[ $totalENC -ge $AlertENC ]]; then
  mailx -s "${SYSSTAT}: sendclmsBklog.ksh Sendclms ENCOUNTERS Backlog" $emailTo1 < $OUTPUT_FILE
else
  echo "Current backlog is within limits"
fi

##Deleting temporary files.
rm -f $OUTPUT_FILE $TEMP_FILE

eoj_msg.csh $0
