 setenv FROM_HISTDIR $DATADIR/claims/newday-bad     
#echo "FROM_HISTDIR: ${FROM_HISTDIR}"

# Next, move any bad claim that have only attempted loading once (has a single bad prefix) back into the input/YYYYMMDD-bad directory
echo Attempting to move any "singly-loaded" Historical claims files from ${FROM_HISTDIR} to ${FROM_DIR}/${TODAY} directory
# Does the directory contain any files
foreach FILE (`ls ${FROM_HISTDIR}`)
#echo "FILE: $FILE"
   if (`echo $FILE | awk -F. '{print $1}'` == "bad" && \
       `echo $FILE | awk -F. '{print $2}'` != "bad") then
      #Move this file to the current day's loading folder
      if ( ! -e ${FROM_DIR}/${TODAY}/${FILE} ) then
         mv ${FROM_HISTDIR}/${FILE} ${FROM_DIR}/${TODAY}/${FILE}
         echo "Moved $FILE to ${FROM_DIR}/$TODAY/$FILE"
	 echo ""
      else
         echo "ERROR: $FILE already exists in ${FROM_DIR}/${TODAY}.  It should not"
         exit -1
      endif
    endif
end
