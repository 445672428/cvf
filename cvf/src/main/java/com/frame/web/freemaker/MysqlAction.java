package com.frame.web.freemaker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.base.BaseAction;
import com.hibernate.pojo.ColumnsPriv;
import com.hibernate.pojo.CondInstances;
import com.hibernate.pojo.Db;
import com.hibernate.pojo.Event;
import com.hibernate.pojo.EventsWaitsCurrent;
import com.hibernate.pojo.EventsWaitsHistory;
import com.hibernate.pojo.EventsWaitsHistoryLong;
import com.hibernate.pojo.EventsWaitsSummaryByInstance;
import com.hibernate.pojo.EventsWaitsSummaryByThreadByEventName;
import com.hibernate.pojo.EventsWaitsSummaryGlobalByEventName;
import com.hibernate.pojo.FileInstances;
import com.hibernate.pojo.FileSummaryByEventName;
import com.hibernate.pojo.FileSummaryByInstance;
import com.hibernate.pojo.Func;
import com.hibernate.pojo.GeneralLog;
import com.hibernate.pojo.HelpCategory;
import com.hibernate.pojo.HelpKeyword;
import com.hibernate.pojo.HelpRelation;
import com.hibernate.pojo.HelpTopic;
import com.hibernate.pojo.Host;
import com.hibernate.pojo.MutexInstances;
import com.hibernate.pojo.NdbBinlogIndex;
import com.hibernate.pojo.PerformanceTimers;
import com.hibernate.pojo.Plugin;
import com.hibernate.pojo.Proc;
import com.hibernate.pojo.ProcsPriv;
import com.hibernate.pojo.ProxiesPriv;
import com.hibernate.pojo.RwlockInstances;
import com.hibernate.pojo.Servers;
import com.hibernate.pojo.SetupConsumers;
import com.hibernate.pojo.SetupInstruments;
import com.hibernate.pojo.SetupTimers;
import com.hibernate.pojo.SlowLog;
import com.hibernate.pojo.TablesPriv;
import com.hibernate.pojo.Threads;
import com.hibernate.pojo.TimeZone;
import com.hibernate.pojo.TimeZoneLeapSecond;
import com.hibernate.pojo.TimeZoneName;
import com.hibernate.pojo.TimeZoneTransition;
import com.hibernate.pojo.TimeZoneTransitionType;
import com.hibernate.pojo.User;
import com.hibernate.service.ColumnsPrivService;
import com.hibernate.service.CondInstancesService;
import com.hibernate.service.DbService;
import com.hibernate.service.EventService;
import com.hibernate.service.EventsWaitsCurrentService;
import com.hibernate.service.EventsWaitsHistoryLongService;
import com.hibernate.service.EventsWaitsHistoryService;
import com.hibernate.service.EventsWaitsSummaryByInstanceService;
import com.hibernate.service.EventsWaitsSummaryByThreadByEventNameService;
import com.hibernate.service.EventsWaitsSummaryGlobalByEventNameService;
import com.hibernate.service.FileInstancesService;
import com.hibernate.service.FileSummaryByEventNameService;
import com.hibernate.service.FileSummaryByInstanceService;
import com.hibernate.service.FuncService;
import com.hibernate.service.GeneralLogService;
import com.hibernate.service.HelpCategoryService;
import com.hibernate.service.HelpKeywordService;
import com.hibernate.service.HelpRelationService;
import com.hibernate.service.HelpTopicService;
import com.hibernate.service.HostService;
import com.hibernate.service.MutexInstancesService;
import com.hibernate.service.NdbBinlogIndexService;
import com.hibernate.service.PerformanceTimersService;
import com.hibernate.service.PluginService;
import com.hibernate.service.ProcService;
import com.hibernate.service.ProcsPrivService;
import com.hibernate.service.ProxiesPrivService;
import com.hibernate.service.RwlockInstancesService;
import com.hibernate.service.ServersService;
import com.hibernate.service.SetupConsumersService;
import com.hibernate.service.SetupInstrumentsService;
import com.hibernate.service.SetupTimersService;
import com.hibernate.service.SlowLogService;
import com.hibernate.service.TablesPrivService;
import com.hibernate.service.ThreadsService;
import com.hibernate.service.TimeZoneLeapSecondService;
import com.hibernate.service.TimeZoneNameService;
import com.hibernate.service.TimeZoneService;
import com.hibernate.service.TimeZoneTransitionService;
import com.hibernate.service.TimeZoneTransitionTypeService;
import com.hibernate.service.UserService;
import com.mybatis.mapper.CHARACTER_SETSMapper;
import com.mybatis.mapper.COLLATIONSMapper;
import com.mybatis.mapper.COLLATION_CHARACTER_SET_APPLICABILITYMapper;
import com.mybatis.mapper.COLUMNSMapper;
import com.mybatis.mapper.COLUMN_PRIVILEGESMapper;
import com.mybatis.mapper.ENGINESMapper;
import com.mybatis.mapper.EVENTSMapper;
import com.mybatis.mapper.FILESMapper;
import com.mybatis.mapper.GLOBAL_STATUSMapper;
import com.mybatis.mapper.GLOBAL_VARIABLESMapper;
import com.mybatis.mapper.INNODB_CMPMEMMapper;
import com.mybatis.mapper.INNODB_CMPMEM_RESETMapper;
import com.mybatis.mapper.INNODB_CMPMapper;
import com.mybatis.mapper.INNODB_CMP_RESETMapper;
import com.mybatis.mapper.INNODB_LOCKSMapper;
import com.mybatis.mapper.INNODB_LOCK_WAITSMapper;
import com.mybatis.mapper.INNODB_TRXMapper;
import com.mybatis.mapper.KEY_COLUMN_USAGEMapper;
import com.mybatis.mapper.PARAMETERSMapper;
import com.mybatis.mapper.PLUGINSMapper;
import com.mybatis.mapper.PROCESSLISTMapper;
import com.mybatis.mapper.PROFILINGMapper;
import com.mybatis.mapper.REFERENTIAL_CONSTRAINTSMapper;
import com.mybatis.mapper.ROUTINESMapper;
import com.mybatis.mapper.SCHEMATAMapper;
import com.mybatis.mapper.SCHEMA_PRIVILEGESMapper;
import com.mybatis.mapper.SESSION_STATUSMapper;
import com.mybatis.mapper.SESSION_VARIABLESMapper;
import com.mybatis.mapper.STATISTICSMapper;
import com.mybatis.mapper.TABLESMapper;
import com.mybatis.mapper.TABLESPACESMapper;
import com.mybatis.mapper.TABLE_CONSTRAINTSMapper;
import com.mybatis.mapper.TABLE_PRIVILEGESMapper;
import com.mybatis.mapper.TRIGGERSMapper;
import com.mybatis.mapper.USER_PRIVILEGESMapper;
import com.mybatis.mapper.VIEWSMapper;
import com.mybatis.pojo.CHARACTER_SETS;
import com.mybatis.pojo.COLLATIONS;
import com.mybatis.pojo.COLLATION_CHARACTER_SET_APPLICABILITY;
import com.mybatis.pojo.COLUMNS;
import com.mybatis.pojo.COLUMN_PRIVILEGES;
import com.mybatis.pojo.ENGINES;
import com.mybatis.pojo.EVENTS;
import com.mybatis.pojo.FILES;
import com.mybatis.pojo.GLOBAL_STATUS;
import com.mybatis.pojo.GLOBAL_VARIABLES;
import com.mybatis.pojo.INNODB_CMP;
import com.mybatis.pojo.INNODB_CMPMEM;
import com.mybatis.pojo.INNODB_CMPMEM_RESET;
import com.mybatis.pojo.INNODB_CMP_RESET;
import com.mybatis.pojo.INNODB_LOCKS;
import com.mybatis.pojo.INNODB_LOCK_WAITS;
import com.mybatis.pojo.INNODB_TRX;
import com.mybatis.pojo.KEY_COLUMN_USAGE;
import com.mybatis.pojo.PARAMETERS;
import com.mybatis.pojo.PLUGINS;
import com.mybatis.pojo.PROCESSLIST;
import com.mybatis.pojo.PROFILING;
import com.mybatis.pojo.REFERENTIAL_CONSTRAINTS;
import com.mybatis.pojo.ROUTINES;
import com.mybatis.pojo.SCHEMATA;
import com.mybatis.pojo.SCHEMA_PRIVILEGES;
import com.mybatis.pojo.SESSION_STATUS;
import com.mybatis.pojo.SESSION_VARIABLES;
import com.mybatis.pojo.STATISTICS;
import com.mybatis.pojo.TABLES;
import com.mybatis.pojo.TABLESPACES;
import com.mybatis.pojo.TABLE_CONSTRAINTS;
import com.mybatis.pojo.TABLE_PRIVILEGES;
import com.mybatis.pojo.TRIGGERS;
import com.mybatis.pojo.USER_PRIVILEGES;
import com.mybatis.pojo.VIEWS;

@Controller
@RequestMapping(value="mysql")
public class MysqlAction extends BaseAction{
	private static final LinkedHashMap<Integer, String> TREE_MAP = new LinkedHashMap<Integer, String>(){{
		put(1,"Host");
		put(2,"ColumnsPriv");
		put(3,"CondInstances");
		put(4,"Db");
		put(5,"Event");
		put(6,"EventsWaitsCurrent");
		put(7,"EventsWaitsHistory");
		put(8,"EventsWaitsHistoryLong");
		put(9,"EventsWaitsSummaryByInstance");
		put(10,"EventsWaitsSummaryByThreadByEventName");
		put(11,"EventsWaitsSummaryGlobalByEventName");
		put(12,"FileInstances");
		put(13,"FileSummaryByEventName");
		put(14,"FileSummaryByInstance");
		put(15,"Func");
		put(16,"GeneralLog");
		put(17,"HelpCategory");
		put(18,"HelpKeyword");
		put(19,"HelpRelation");
		put(20,"HelpTopic");
		put(21,"MutexInstances");
		put(22,"NdbBinlogIndex");
		put(23,"PerformanceTimers");
		put(24,"Plugin");
		put(25,"Proc");
		put(26,"ProcsPriv");
		put(27,"ProxiesPriv");
		put(28,"RwlockInstances");
		put(29,"Servers");
		put(30,"SetupConsumers");
		put(31,"SetupInstruments");
		put(32,"SetupTimers");
		put(33,"SlowLog");
		put(34,"TablesPriv");
		put(35,"Threads");
		put(36,"TimeZone");
		put(37,"TimeZoneLeapSecond");
		put(38,"TimeZoneName");
		put(39,"TimeZoneTransition");
		put(40,"TimeZoneTransitionType");
		put(41,"User");
		put(42,"CHARACTER_SETS");
		put(43,"COLLATION_CHARACTER_SET_APPLICABILITY");
		put(44,"COLLATIONS");
		put(45,"COLUMN_PRIVILEGES");
		put(46,"COLUMNS");
		put(47,"ENGINES");
		put(48,"EVENTS");
		put(49,"FILES");
		put(50,"GLOBAL_STATUS");
		put(51,"GLOBAL_VARIABLES");
		put(52,"INNODB_CMP_RESET");
		put(53,"INNODB_CMP");
		put(54,"INNODB_CMPMEM_RESET");
		put(55,"INNODB_CMPMEM");
		put(56,"INNODB_LOCK_WAITS");
		put(57,"INNODB_LOCKS");
		put(58,"INNODB_TRX");
		put(59,"KEY_COLUMN_USAGE");
		put(60,"PARAMETERS");
		put(61,"PLUGINS");
		put(62,"PROCESSLIST");
		put(63,"PROFILING");
		put(64,"REFERENTIAL_CONSTRAINTS");
		put(65,"ROUTINES");
		put(66,"SCHEMA_PRIVILEGES");
		put(67,"SCHEMATA");
		put(68,"SESSION_STATUS");
		put(69,"SESSION_VARIABLES");
		put(70,"STATISTICS");
		put(71,"TABLE_CONSTRAINTS");
		put(72,"TABLE_PRIVILEGES");
		put(73,"TABLES");
		put(74,"TABLESPACES");
		put(75,"TRIGGERS");
		put(76,"USER_PRIVILEGES");
		put(77,"VIEWS");
	}};
	
	@RequestMapping(value="/host",method=RequestMethod.GET)
	public ModelAndView queryHost(ModelAndView view,@RequestParam(value = "p", required = false, defaultValue = "1")  Integer p){
		List<Map<String, Object>> results = new ArrayList<Map<String,Object>>();
		switch (p) {
		case 1:
			List<Host> list1 = (List<Host>) hostService.findAll();
			view.addObject("results", list1);
			break;
		case 2:
			List<ColumnsPriv> list2 = (List<ColumnsPriv>) columnsPrivService.findAll();
			view.addObject("results", list2);
			break;
		case 3:
			List<CondInstances> list3 = (List<CondInstances>) condInstancesService.findAll();
			view.addObject("results", list3);
			break;
		case 4:
			List<Db> list4 = (List<Db>) dbService.findAll();
			view.addObject("results", list4);
			break;
		case 5:
			List<Event> list5 = (List<Event>) eventService.findAll();
			view.addObject("results", list5);
			break;
		case 6:
			List<EventsWaitsCurrent> list6 = (List<EventsWaitsCurrent>) eventsWaitsCurrentService.findAll();
			view.addObject("results", list6);
			break;
		case 7:
			List<EventsWaitsHistory> list7 = (List<EventsWaitsHistory>) eventsWaitsHistoryService.findAll();
			view.addObject("results", list7);
			break;
		case 8:
			List<EventsWaitsHistoryLong> list8 = (List<EventsWaitsHistoryLong>) eventsWaitsHistoryLongService.findAll();
			view.addObject("results", list8);
			break;
		case 9:
			List<EventsWaitsSummaryByInstance> list9 = (List<EventsWaitsSummaryByInstance>) eventsWaitsSummaryByInstanceService.findAll();
			view.addObject("results", list9);
			break;
		case 10:
			List<EventsWaitsSummaryByThreadByEventName> list10 = (List<EventsWaitsSummaryByThreadByEventName>) eventsWaitsSummaryByThreadByEventNameService.findAll();
			view.addObject("results", list10);
			break;
		case 11:
			List<EventsWaitsSummaryGlobalByEventName> list11 = (List<EventsWaitsSummaryGlobalByEventName>) eventsWaitsSummaryGlobalByEventNameService.findAll();
			view.addObject("results", list11);
			break;
		case 12:
			List<FileInstances> list12 = (List<FileInstances>) fileInstancesService.findAll();
			view.addObject("results", list12);
			break;
		case 13:
			List<FileSummaryByEventName> list13 = (List<FileSummaryByEventName>) fileSummaryByEventNameService.findAll();
			view.addObject("results", list13);
			break;
		case 14:
			List<FileSummaryByInstance> list14 = (List<FileSummaryByInstance>) fileSummaryByInstanceService.findAll();
			view.addObject("results", list14);
			break;
		case 15:
			List<Func> list15 = (List<Func>) funcService.findAll();
			view.addObject("results", list15);
			break;
		case 16:
			List<GeneralLog> list16 = (List<GeneralLog>) generalLogService.findAll();
			view.addObject("results", list16);
			break;
		case 17:
			List<HelpCategory> list17 = (List<HelpCategory>) helpCategoryService.findAll();
			view.addObject("results", list17);
			break;
		case 18:
			List<HelpKeyword> list18 = (List<HelpKeyword>) helpKeywordService.findAll();
			view.addObject("results", list18);
			break;
		case 19:
			List<HelpRelation> list19 = (List<HelpRelation>) helpRelationService.findAll();
			view.addObject("results", list19);
			break;
		case 20:
			List<HelpTopic> list20 = (List<HelpTopic>) helpTopicService.findAll();
			view.addObject("results", list20);
			break;
		case 21:
			List<MutexInstances> list21 = (List<MutexInstances>) mutexInstancesService.findAll();
			view.addObject("results", list21);
			break;
		case 22:
			List<NdbBinlogIndex> list22 = (List<NdbBinlogIndex>) ndbBinlogIndexService.findAll();
			view.addObject("results", list22);
			break;
		case 23:
			List<PerformanceTimers> list23 = (List<PerformanceTimers>) performanceTimersService.findAll();
			view.addObject("results", list23);
			break;
		case 24:
			List<Plugin> list24 = (List<Plugin>) pluginService.findAll();
			view.addObject("results", list24);
			break;
		case 25:
			List<Proc> list25 = (List<Proc>) procService.findAll();
			view.addObject("results", list25);
			break;
		case 26:
			List<ProcsPriv> list26 = (List<ProcsPriv>) procsPrivService.findAll();
			view.addObject("results", list26);
			break;
		case 27:
			List<ProxiesPriv> list27 = (List<ProxiesPriv>) proxiesPrivService.findAll();
			view.addObject("results", list27);
			break;
		case 28:
			List<RwlockInstances> list28 = (List<RwlockInstances>) rwlockInstancesService.findAll();
			view.addObject("results", list28);
			break;
		case 29:
			List<Servers> list29 = (List<Servers>) serversService.findAll();
			view.addObject("results", list29);
			break;
		case 30:
			List<SetupConsumers> list30 = (List<SetupConsumers>) setupConsumersService.findAll();
			view.addObject("results", list30);
			break;
		case 31:
			List<SetupInstruments> list31 = (List<SetupInstruments>) setupInstrumentsService.findAll();
			view.addObject("results", list31);
			break;
		case 32:
			List<SetupTimers> list32 = (List<SetupTimers>) setupTimersService.findAll();
			view.addObject("results", list32);
			break;
		case 33:
			List<SlowLog> list33 = (List<SlowLog>) slowLogService.findAll();
			view.addObject("results", list33);
			break;
		case 34:
			List<TablesPriv> list34 = (List<TablesPriv>) tablesPrivService.findAll();
			view.addObject("results", list34);
			break;
		case 35:
			List<Threads> list35 = (List<Threads>) threadsService.findAll();
			view.addObject("results", list35);
			break;
		case 36:
			List<TimeZone> list36 = (List<TimeZone>) timeZoneService.findAll();
			view.addObject("results", list36);
			break;
		case 37:
			List<TimeZoneLeapSecond> list37 = (List<TimeZoneLeapSecond>) timeZoneLeapSecondService.findAll();
			view.addObject("results", list37);
			break;
		case 38:
			List<TimeZoneName> list38 = (List<TimeZoneName>) timeZoneNameService.findAll();
			view.addObject("results", list38);
			break;
		case 39:
			List<TimeZoneTransition> list39 = (List<TimeZoneTransition>) timeZoneTransitionService.findAll();
			view.addObject("results", list39);
			break;
		case 40:
			List<TimeZoneTransitionType> list40 = (List<TimeZoneTransitionType>) timeZoneTransitionTypeService.findAll();
			view.addObject("results", list40);
			break;
		case 41:
			List<User> list41 = (List<User>) userService.findAll();
			results = arrayObjectToList(list41);
			break;
		case 42:
			List<CHARACTER_SETS> list42 = cHARACTER_SETSMapper.selectByExample(null);
			results = arrayObjectToList(list42);
			break;
		case 43:
			List<COLLATION_CHARACTER_SET_APPLICABILITY> list43 = cOLLATION_CHARACTER_SET_APPLICABILITYMapper.selectByExample(null);
			results = arrayObjectToList(list43);
			break;
		case 44:
			List<COLLATIONS> list44 = cOLLATIONSMapper.selectByExample(null);
			results = arrayObjectToList(list44);
			break;
		case 45:
			List<COLUMN_PRIVILEGES> list45 = cOLUMN_PRIVILEGESMapper.selectByExample(null);
			results = arrayObjectToList(list45);
			break;
		case 46:
			List<COLUMNS> list46 = cOLUMNSMapper.selectByExample(null);
			results = arrayObjectToList(list46);
			break;
		case 47:
			List<ENGINES> list47 = eNGINESMapper.selectByExample(null);
			results = arrayObjectToList(list47);
			break;
		case 48:
			List<EVENTS> list48 = eVENTSMapper.selectByExample(null);
			results = arrayObjectToList(list48);
			break;
		case 49:
			List<FILES> list49 = fILESMapper.selectByExample(null);
			results = arrayObjectToList(list49);
			break;
		case 50:
			List<GLOBAL_STATUS> list50 = gLOBAL_STATUSMapper.selectByExample(null);
			results = arrayObjectToList(list50);
			break;
		case 51:
			List<GLOBAL_VARIABLES> list51 = gLOBAL_VARIABLESMapper.selectByExample(null);
			results = arrayObjectToList(list51);
			break;
		case 52:
			List<INNODB_CMP_RESET> list52 = iNNODB_CMP_RESETMapper.selectByExample(null);
			results = arrayObjectToList(list52);
			break;
		case 53:
			List<INNODB_CMP> list53 = iNNODB_CMPMapper.selectByExample(null);
			results = arrayObjectToList(list53);
			break;
		case 54:
			List<INNODB_CMPMEM_RESET> list54 = iNNODB_CMPMEM_RESETMapper.selectByExample(null);
			results = arrayObjectToList(list54);
			break;
		case 55:
			List<INNODB_CMPMEM> list55 = iNNODB_CMPMEMMapper.selectByExample(null);
			results = arrayObjectToList(list55);
			break;
		case 56:
			List<INNODB_LOCK_WAITS> list56 = iNNODB_LOCK_WAITSMapper.selectByExample(null);
			results = arrayObjectToList(list56);
			break;
		case 57:
			List<INNODB_LOCKS> list57 = iNNODB_LOCKSMapper.selectByExample(null);
			results = arrayObjectToList(list57);
			break;
		case 58:
			List<INNODB_TRX> list58 = iNNODB_TRXMapper.selectByExample(null);
			view.addObject("results", list58);
			break;
		case 59:
			List<KEY_COLUMN_USAGE> list59 = kEY_COLUMN_USAGEMapper.selectByExample(null);
			results = arrayObjectToList(list59);
			break;
		case 60:
			List<PARAMETERS> list60 = pARAMETERSMapper.selectByExample(null);
			results = arrayObjectToList(list60);
			break;
		case 61:
			List<PLUGINS> list61 = pLUGINSMapper.selectByExample(null);
			results = arrayObjectToList(list61);
			break;
		case 62:
			List<PROCESSLIST> list62 = pROCESSLISTMapper.selectByExample(null);
			results = arrayObjectToList(list62);
			break;
		case 63:
			List<PROFILING> list63 = pROFILINGMapper.selectByExample(null);
			results = arrayObjectToList(list63);
			break;
		case 64:
			List<REFERENTIAL_CONSTRAINTS> list64 = rEFERENTIAL_CONSTRAINTSMapper.selectByExample(null);
			results = arrayObjectToList(list64);
			break;
		case 65:
			List<ROUTINES> list65 = rOUTINESMapper.selectByExample(null);
			results = arrayObjectToList(list65);
			break;
		case 66:
			List<SCHEMA_PRIVILEGES> list66 = sCHEMA_PRIVILEGESMapper.selectByExample(null);
			results = arrayObjectToList(list66);
			break;
		case 67:
			List<SCHEMATA> list67 = sCHEMATAMapper.selectByExample(null);
			results = arrayObjectToList(list67);
			break;
		case 68:
			List<SESSION_STATUS> list68 = sESSION_STATUSMapper.selectByExample(null);
			results = arrayObjectToList(list68);
			break;
		case 69:
			List<SESSION_VARIABLES> list69 = sESSION_VARIABLESMapper.selectByExample(null);
			results = arrayObjectToList(list69);
			break;
		case 70:
			List<STATISTICS> list70 = sTATISTICSMapper.selectByExample(null);
			results = arrayObjectToList(list70);
			break;
		case 71:
			List<TABLE_CONSTRAINTS> list71 = tABLE_CONSTRAINTSMapper.selectByExample(null);
			results = arrayObjectToList(list71);
			break;
		case 72:
			List<TABLE_PRIVILEGES> list72 = tABLE_PRIVILEGESMapper.selectByExample(null);
			results = arrayObjectToList(list72);
			break;
		case 73:
			List<TABLES> list73 = tABLESMapper.selectByExample(null);
			results = arrayObjectToList(list73);
			break;
		case 74:
			List<TABLESPACES> list74 = tABLESPACESMapper.selectByExample(null);
			results = arrayObjectToList(list74);
			break;
		case 75:
			List<TRIGGERS> list75 = tRIGGERSMapper.selectByExample(null);
			results = arrayObjectToList(list75);
			break;
		case 76:
			List<USER_PRIVILEGES> list76 = uSER_PRIVILEGESMapper.selectByExample(null);
			results = arrayObjectToList(list76);
			break;
		case 77:
			List<VIEWS> list77 = vIEWSMapper.selectByExample(null);
			results = arrayObjectToList(list77);
			break;
		default:
			break;
		}
		JSONArray treeArray = new JSONArray();
		for (Map.Entry<Integer, String> entry : TREE_MAP.entrySet()) {
			JSONObject obj = new JSONObject();
			obj.put("id", entry.getKey());
			obj.put("name", entry.getValue());
			treeArray.add(obj);
		}
		view.addObject("zNodes", treeArray);
		view.addObject("results", results);
		view.addObject("p", p);
		view.setViewName("mysql");
		return view;
	}
	@Autowired
	private CHARACTER_SETSMapper cHARACTER_SETSMapper;
	@Autowired
	private COLLATION_CHARACTER_SET_APPLICABILITYMapper cOLLATION_CHARACTER_SET_APPLICABILITYMapper;
	@Autowired
	private COLLATIONSMapper cOLLATIONSMapper;
	@Autowired
	private COLUMN_PRIVILEGESMapper cOLUMN_PRIVILEGESMapper;
	@Autowired
	private COLUMNSMapper cOLUMNSMapper;
	@Autowired
	private ENGINESMapper eNGINESMapper;
	@Autowired
	private EVENTSMapper eVENTSMapper;
	@Autowired
	private FILESMapper fILESMapper;
	@Autowired
	private GLOBAL_STATUSMapper gLOBAL_STATUSMapper;
	@Autowired
	private GLOBAL_VARIABLESMapper gLOBAL_VARIABLESMapper;
	@Autowired
	private INNODB_CMP_RESETMapper iNNODB_CMP_RESETMapper;
	@Autowired
	private INNODB_CMPMapper iNNODB_CMPMapper;
	@Autowired
	private INNODB_CMPMEM_RESETMapper iNNODB_CMPMEM_RESETMapper;
	@Autowired
	private INNODB_CMPMEMMapper iNNODB_CMPMEMMapper;
	@Autowired
	private INNODB_LOCK_WAITSMapper iNNODB_LOCK_WAITSMapper;
	@Autowired
	private INNODB_LOCKSMapper iNNODB_LOCKSMapper;
	@Autowired
	private INNODB_TRXMapper iNNODB_TRXMapper;
	@Autowired
	private KEY_COLUMN_USAGEMapper kEY_COLUMN_USAGEMapper;
	@Autowired
	private PARAMETERSMapper pARAMETERSMapper;
	@Autowired
	private PLUGINSMapper pLUGINSMapper;
	@Autowired
	private PROCESSLISTMapper pROCESSLISTMapper;
	@Autowired
	private PROFILINGMapper pROFILINGMapper;
	@Autowired
	private REFERENTIAL_CONSTRAINTSMapper rEFERENTIAL_CONSTRAINTSMapper;
	@Autowired
	private ROUTINESMapper rOUTINESMapper;
	@Autowired
	private SCHEMA_PRIVILEGESMapper sCHEMA_PRIVILEGESMapper;
	@Autowired
	private SCHEMATAMapper sCHEMATAMapper;
	@Autowired
	private SESSION_STATUSMapper sESSION_STATUSMapper;
	@Autowired
	private SESSION_VARIABLESMapper sESSION_VARIABLESMapper;
	@Autowired
	private STATISTICSMapper sTATISTICSMapper;
	@Autowired
	private TABLE_CONSTRAINTSMapper tABLE_CONSTRAINTSMapper;
	@Autowired
	private TABLE_PRIVILEGESMapper tABLE_PRIVILEGESMapper;
	@Autowired
	private TABLESMapper tABLESMapper;
	@Autowired
	private TABLESPACESMapper tABLESPACESMapper;
	@Autowired
	private TRIGGERSMapper tRIGGERSMapper;
	@Autowired
	private USER_PRIVILEGESMapper uSER_PRIVILEGESMapper;
	@Autowired
	private VIEWSMapper vIEWSMapper;
	
	
	
	@Autowired
	private HostService hostService;
	@Autowired
	private ColumnsPrivService columnsPrivService;
	@Autowired
	private CondInstancesService condInstancesService;
	@Autowired
	private DbService dbService;
	@Autowired
	private EventService eventService;
	@Autowired
	private EventsWaitsCurrentService eventsWaitsCurrentService;
	@Autowired
	private EventsWaitsHistoryService eventsWaitsHistoryService;
	@Autowired
	private EventsWaitsHistoryLongService eventsWaitsHistoryLongService;
	@Autowired
	private EventsWaitsSummaryByInstanceService eventsWaitsSummaryByInstanceService;
	@Autowired
	private EventsWaitsSummaryByThreadByEventNameService eventsWaitsSummaryByThreadByEventNameService;
	@Autowired
	private EventsWaitsSummaryGlobalByEventNameService eventsWaitsSummaryGlobalByEventNameService;
	@Autowired
	private FileInstancesService fileInstancesService;
	@Autowired
	private FileSummaryByEventNameService fileSummaryByEventNameService;
	@Autowired
	private FileSummaryByInstanceService fileSummaryByInstanceService;
	@Autowired
	private FuncService funcService;
	@Autowired
	private GeneralLogService generalLogService;
	@Autowired
	private HelpCategoryService helpCategoryService;
	@Autowired
	private HelpKeywordService helpKeywordService;
	@Autowired
	private HelpRelationService helpRelationService;
	@Autowired
	private HelpTopicService helpTopicService;
	@Autowired
	private MutexInstancesService mutexInstancesService;
	
	@Autowired
	private NdbBinlogIndexService ndbBinlogIndexService;
	@Autowired
	private PerformanceTimersService performanceTimersService;
	@Autowired
	private PluginService pluginService;
	@Autowired
	private ProcService procService;
	@Autowired
	private ProcsPrivService procsPrivService;
	@Autowired
	private ProxiesPrivService proxiesPrivService;
	@Autowired
	private RwlockInstancesService rwlockInstancesService;
	@Autowired
	private ServersService serversService;
	@Autowired
	private SetupConsumersService setupConsumersService;
	@Autowired
	private SetupInstrumentsService setupInstrumentsService;
	@Autowired
	private SetupTimersService setupTimersService;
	@Autowired
	private SlowLogService slowLogService;
	@Autowired
	private TablesPrivService tablesPrivService;
	@Autowired
	private ThreadsService threadsService;
	@Autowired
	private TimeZoneService timeZoneService;
	@Autowired
	private TimeZoneLeapSecondService timeZoneLeapSecondService;
	@Autowired
	private TimeZoneNameService timeZoneNameService;
	@Autowired
	private TimeZoneTransitionService timeZoneTransitionService;
	@Autowired
	private TimeZoneTransitionTypeService timeZoneTransitionTypeService;
	@Autowired
	private UserService userService;
}
