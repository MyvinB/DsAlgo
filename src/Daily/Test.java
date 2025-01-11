package Daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class Test {

    public static void main(String[] args) {
    String pg ="t_actl_bag_itin\n" +
            "t_actl_psgr_itin\n" +
            "t_al\n" +
            "t_ap\n" +
            "t_ap_bag_dlvry_est\n" +
            "t_ap_bag_loss_rsn_typ\n" +
            "t_ap_dlvry_vndr\n" +
            "t_ap_dlvry_vndr_bkup1\n" +
            "t_ap_gnd_hdl\n" +
            "t_ap_trm_cncrs\n" +
            "t_ap_vndr\n" +
            "t_ap_zip_dlvry_cst\n" +
            "t_atmd_msg_typ\n" +
            "t_bag_brand\n" +
            "t_bag_case_dtl\n" +
            "t_bag_case_flt_dtl\n" +
            "t_bag_claim\n" +
            "t_bag_claim_bag\n" +
            "t_bag_claim_err_log\n" +
            "t_bag_claim_itm\n" +
            "t_bag_claim_psgr_atch\n" +
            "t_bag_claim_psgr_atch_temp\n" +
            "t_bag_claim_psgr_itin\n" +
            "t_bag_claim_psgr_rcpt\n" +
            "t_bag_claim_pur_list\n" +
            "t_bag_claim_stats_cde_lkup\n" +
            "t_bag_claim_stats_cde_xref\n" +
            "t_bag_claim_typ\n" +
            "t_bag_cntn_subtyp\n" +
            "t_bag_cntn_typ\n" +
            "t_bag_colr_typ\n" +
            "t_bag_dlvry_bag\n" +
            "t_bag_dlvry_ord\n" +
            "t_bag_dlvry_typ\n" +
            "t_bag_dmg_typ\n" +
            "t_bag_evnt_subtyp\n" +
            "t_bag_evnt_typ\n" +
            "t_bag_loss_rsn\n" +
            "t_bag_loss_rsn_ownr\n" +
            "t_bag_loss_rsn_typ\n" +
            "t_bag_msg_appl\n" +
            "t_bag_tag_typ\n" +
            "t_bag_trace_cntn\n" +
            "t_bag_tty_prntr\n" +
            "t_bag_tty_prntr_usr\n" +
            "t_bag_typ\n" +
            "t_cabn_cls\n" +
            "t_crr_vndr_pckp_sched\n" +
            "t_currency\n" +
            "t_cust_care\n" +
            "t_dlvry_opt_typ\n" +
            "t_dmg_ext_typ\n" +
            "t_dmg_sect\n" +
            "t_eml_fmt_typ\n" +
            "t_encr_key\n" +
            "t_fastrak_dlay_proact_ntfy\n" +
            "t_fastrak_scrn_hdr_fter\n" +
            "t_ff_prog\n" +
            "t_ff_stats\n" +
            "t_ff_tier\n" +
            "t_file_typ\n" +
            "t_flt_cshr\n" +
            "t_iata_bag_typ\n" +
            "t_intl_ap_trm_cncrs\n" +
            "t_mishdl_cst_typ\n" +
            "t_mishdld_bag_file\n" +
            "t_mishdld_bag_file_add_msg\n" +
            "t_mishdld_bag_file_addr\n" +
            "t_mishdld_bag_file_addr_typ\n" +
            "t_mishdld_bag_file_bag\n" +
            "t_mishdld_bag_file_bag_cntn\n" +
            "t_mishdld_bag_file_bag_dmg\n" +
            "t_mishdld_bag_file_cmmt\n" +
            "t_mishdld_bag_file_cst_pymt\n" +
            "t_mishdld_bag_file_email_msg\n" +
            "t_mishdld_bag_file_eml\n" +
            "t_mishdld_bag_file_err\n" +
            "t_mishdld_bag_file_fault\n" +
            "t_mishdld_bag_file_intnt_msg\n" +
            "t_mishdld_bag_file_phn_num\n" +
            "t_mishdld_bag_file_phn_typ\n" +
            "t_mishdld_bag_file_sms_msg\n" +
            "t_mishdld_bag_file_stats\n" +
            "t_mishdld_bag_file_stats_hist\n" +
            "t_mishdld_bag_file_usr_cmmt\n" +
            "t_mishdld_bag_sys_agt\n" +
            "t_mishdld_bag_sys_tran_log\n" +
            "t_net_trcr_clm_websvc_err\n" +
            "t_net_trcr_clm_websvc_rspn\n" +
            "t_ntfy_msg\n" +
            "t_ntfy_msg_usr_login\n" +
            "t_prev_bag_claim\n" +
            "t_proact_ntfy_pref_lang\n" +
            "t_quick_onh_bag\n" +
            "t_quick_onh_tran\n" +
            "t_rplcm_bag_typ\n" +
            "t_sched_bag_itin\n" +
            "t_sched_psgr_itin\n" +
            "t_stlmt_stats\n" +
            "t_wldtrcr_crcy\n";

    String oracle = "T_ACTL_BAG_ITIN\n" +
            "T_ACTL_PSGR_ITIN\n" +
            "T_AL\n" +
            "T_AP\n" +
            "T_AP_BAG_DLVRY_EST\n" +
            "T_AP_BAG_LOSS_RSN_TYP\n" +
            "T_AP_DLVRY_VNDR\n" +
            "T_AP_DLVRY_VNDR_BKUP1\n" +
            "T_AP_GND_HDL\n" +
            "T_AP_TRM_CNCRS\n" +
            "T_AP_VNDR\n" +
            "T_AP_ZIP_DLVRY_CST\n" +
            "T_ATMD_MSG_TYP\n" +
            "T_BAG_BRAND\n" +
            "T_BAG_CASE_DTL\n" +
            "T_BAG_CASE_FLT_DTL\n" +
            "T_BAG_CLAIM\n" +
            "T_BAG_CLAIM_BAG\n" +
            "T_BAG_CLAIM_ERR_LOG\n" +
            "T_BAG_CLAIM_ITM\n" +
            "T_BAG_CLAIM_PSGR_ATCH\n" +
            "T_BAG_CLAIM_PSGR_ATCH_TEMP\n" +
            "T_BAG_CLAIM_PSGR_ITIN\n" +
            "T_BAG_CLAIM_PSGR_RCPT\n" +
            "T_BAG_CLAIM_PUR_LIST\n" +
            "T_BAG_CLAIM_STATS_CDE_LKUP\n" +
            "T_BAG_CLAIM_STATS_CDE_XREF\n" +
            "T_BAG_CLAIM_TYP\n" +
            "T_BAG_CNTN_SUBTYP\n" +
            "T_BAG_CNTN_TYP\n" +
            "T_BAG_COLR_TYP\n" +
            "T_BAG_DLVRY_BAG\n" +
            "T_BAG_DLVRY_ORD\n" +
            "T_BAG_DLVRY_TYP\n" +
            "T_BAG_DMG_TYP\n" +
            "T_BAG_EVNT_SUBTYP\n" +
            "T_BAG_EVNT_TYP\n" +
            "T_BAG_LOSS_RSN\n" +
            "T_BAG_LOSS_RSN_OWNR\n" +
            "T_BAG_LOSS_RSN_TYP\n" +
            "T_BAG_MSG_APPL\n" +
            "T_BAG_TAG_TYP\n" +
            "T_BAG_TRACE_CNTN\n" +
            "T_BAG_TTY_PRNTR\n" +
            "T_BAG_TTY_PRNTR_USR\n" +
            "T_BAG_TYP\n" +
            "T_CABN_CLS\n" +
            "T_CRR_VNDR_PCKP_SCHED\n" +
            "T_CURRENCY\n" +
            "T_CUST_CARE\n" +
            "T_DLVRY_OPT_TYP\n" +
            "T_DMG_EXT_TYP\n" +
            "T_DMG_SECT\n" +
            "T_EML_FMT_TYP\n" +
            "T_ENCR_KEY\n" +
            "T_FASTRAK_DLAY_PROACT_NTFY\n" +
            "T_FASTRAK_SCRN_HDR_FTER\n" +
            "T_FF_PROG\n" +
            "T_FF_STATS\n" +
            "T_FF_TIER\n" +
            "T_FILE_TYP\n" +
            "T_FLT_CSHR\n" +
            "T_IATA_BAG_TYP\n" +
            "T_INTL_AP_TRM_CNCRS\n" +
            "T_MISHDLD_BAG_FILE\n" +
            "T_MISHDLD_BAG_FILE_ADDR\n" +
            "T_MISHDLD_BAG_FILE_ADDR_TYP\n" +
            "T_MISHDLD_BAG_FILE_ADD_MSG\n" +
            "T_MISHDLD_BAG_FILE_BAG\n" +
            "T_MISHDLD_BAG_FILE_BAG_CNTN\n" +
            "T_MISHDLD_BAG_FILE_BAG_DMG\n" +
            "T_MISHDLD_BAG_FILE_CMMT\n" +
            "T_MISHDLD_BAG_FILE_CST_PYMT\n" +
            "T_MISHDLD_BAG_FILE_EMAIL_MSG\n" +
            "T_MISHDLD_BAG_FILE_EML\n" +
            "T_MISHDLD_BAG_FILE_ERR\n" +
            "T_MISHDLD_BAG_FILE_FAULT\n" +
            "T_MISHDLD_BAG_FILE_INTNT_MSG\n" +
            "T_MISHDLD_BAG_FILE_PHN_NUM\n" +
            "T_MISHDLD_BAG_FILE_PHN_TYP\n" +
            "T_MISHDLD_BAG_FILE_SMS_MSG\n" +
            "T_MISHDLD_BAG_FILE_STATS\n" +
            "T_MISHDLD_BAG_FILE_STATS_HIST\n" +
            "T_MISHDLD_BAG_FILE_USR_CMMT\n" +
            "T_MISHDLD_BAG_SYS_AGT\n" +
            "T_MISHDLD_BAG_SYS_TRAN_LOG\n" +
            "T_MISHDLD_FLT_EXT_RPT\n" +
            "T_MISHDL_CST_TYP\n" +
            "T_NET_TRCR_CLM_WEBSVC_ERR\n" +
            "T_NET_TRCR_CLM_WEBSVC_RSPN\n" +
            "T_NTFY_MSG\n" +
            "T_NTFY_MSG_USR_LOGIN\n" +
            "T_PREV_BAG_CLAIM\n" +
            "T_PROACT_NTFY_PREF_LANG\n" +
            "T_QUICK_ONH_BAG\n" +
            "T_QUICK_ONH_TRAN\n" +
            "T_RPLCM_BAG_TYP\n" +
            "T_SCHED_BAG_ITIN\n" +
            "T_SCHED_PSGR_ITIN\n" +
            "T_STLMT_STATS\n" +
            "T_WLDTRCR_CRCY";
    String[] psArr = pg.split("\n");
    String[] oracleArr = oracle.split("\n");
    HashMap<String,Integer> map = new HashMap<>();
    for(int i=0;i<oracleArr.length;i++){
        map.put(oracleArr[i],0);
    }
    for(int i=0;i<psArr.length;i++){
        if(map.containsKey(psArr[i].toUpperCase())){
            map.put(psArr[i].toUpperCase(),map.getOrDefault(psArr[i].toUpperCase(),0)+1);
        }
        else{
            System.out.println(psArr[i] +"Not present");
        }
    }

    for(String m:map.keySet()){
        if(map.get(m)>1){
            System.out.println(m);
        }
    }
        System.out.println("test");
    }


}
