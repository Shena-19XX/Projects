int32_t    dteBirth = 0;
invalid += get_re_dteBirth (&dteBirth);

/*---------------------------  AgeInYears  ---------------------------*/
   /*
   if (claimHdr.yearsOld >= 0)
    {
        sprintf(buf, "%03d", claimHdr.yearsOld);
        gAddMemFail += xml_xt_addTextNode(eapgRequestTxn, "AgeInYears", buf);
    }
    	*/

    /*--------------------------  BirthDate  ---------------------------*/
    {
            /*----  Fields to convert date from CCYYMMDD to CCYY-MM-DD -------------- */
            char SZInFmt[64] = "%Y" "%m" "%d";
            char SZBirth[64] = "";
            char SZOutFmt[64] = "%Y-%m-%d";
        
            LtoSdate(&dteBirth, SZInFmt, SZBirth, SZOutFmt); //reformat date from long YYYYMMDD to GPCS str YYYY-MM-DD */
          
          gAddMemFail += xml_xt_addTextNode(eapgRequestTxn, "BirthDate", SZBirth); 
        	
    }
