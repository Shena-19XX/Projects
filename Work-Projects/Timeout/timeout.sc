static int gpcsRestTimeout = 0; 

/* Get the GPCS timeout length */
	get_int_EAPGParm(&tempInt, "TMOUT", cycleDate);
	gpcsTimeOut = tempInt;
	gpcsRestTimeout = tempInt - 1; 
        /* example parm_value="20" This sets the timeout to 20 seconds */

  
char RestTimeout[8 + 1] = {'\0'}; 
char RestTimeoutStr[8 + 1] = {'\0'}; 

//SiteID
  gAddMemFail += xml_xt_addTextNode(drgRequestTxn, "SiteID", siteIDStr);

  //RestTimeout
  Rest = atoi (RestTimeout) - 1;
  sprintf(RestTimeoutStr, "%d", Rest);
  printf("%s", RestTimeoutStr);
  
  gAddMemFail += xml_xt_addTextNode(drgRequestTxn, "RestTimeout", RestTimeoutStr); 

