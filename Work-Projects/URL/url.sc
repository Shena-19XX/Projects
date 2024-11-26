static char gpcsBaseUrl[20+1] = {'\0'};

/* Get the GPCS Base URL  */
get_char_EAPGParm(buf, "URL2", cycleDate);
strcpy(gpcsBaseUrl, buf);

sprintf(gpcs_xml_hdr, "<processClaimRequestCollection xmlns=\"http://"\
"%s/standard/%s\" xmlns:xsi=\"http://www.w3.org"\
"/2001/XMLSchema-instance\">" \
"<processClaimRequest>" \
/*---------------------------  SiteID  -----------------------------*/
	"<SiteID>%s</SiteID>" \
/*---------------------------  URL  --------------------------------*/
"<URL>https://%s/Gpcs/rest/%s/claims/process</URL>", gpcsBaseUrl, gpcsInterfaceVer, gpcsSite, gpcsBaseUrl, gpcsInterfaceVer);
gAddMemFail += xml_xt_addText(eapgRequestTxn, gpcs_xml_hdr);

