package others.demo.activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

public class ActivityDemo {
	public void test1() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	}
	
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	//部署流程定义
	public void test2() {
		DeploymentBuilder deploymentBuilder = processEngine.getRepositoryService().createDeployment();
		//增加一个定义的内容
		deploymentBuilder.addClasspathResource("qjlc.bpmn");
		deploymentBuilder.addClasspathResource("qjlc.png");
		deploymentBuilder.deploy();
	}
	
	//查询流程定义
	public void test3() {
		ProcessDefinitionQuery processDefinitionQuery = processEngine.getRepositoryService().createProcessDefinitionQuery();
		List<ProcessDefinition> list = processDefinitionQuery.list();
		for(ProcessDefinition definition : list){
			System.out.println(definition.getId());
		}
	}
	
	//根据流程定义启动流程实例
	public void test4() {
		//拿到流程定义的id
		String processDefinitionId = "";
		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceById(processDefinitionId);
		System.out.println(processInstance.getId());
	}
	//查询个人任务
	public void test5() {
		TaskQuery taskQuery = processEngine.getTaskService().createTaskQuery();
		taskQuery.taskAssignee("张三");//设置办理人过滤
		taskQuery.orderByTaskCreateTime().desc();
		List<Task> list = taskQuery.listPage(0, 10);
		for(Task task : list){
			System.out.println(task.getId());
		}
	}
	
	//办理个人任务
	public void test6() {
		String taskId = "";
		processEngine.getTaskService().complete(taskId);
	}
	/////////////////////////////////
	////////////////////////////////
	/**
	 * api总结
	 * 	Deployment  -act_re_deployment
	 * ProcessDefinition  re_procdef
	 * ProcessInstance  act_ru_execution
	 * Task 
	 * DeploymentQuery
	 * ProcessDefinitionQuery
	 * ProcessInstanceQuery
	 * TaskQuery act_ru_task
	 * 
	 * RepositoryService	操作流程部署表
	 * RuntimeService	操作流程实例表
	 * TaskService	操作任务表
	 * HistoryService	历史记录表
	 * IdentityService  用户操作表 关系表
	 * */
	
	
	
	//启动流程变量的方式
		public void test7() {
			String processDefinitionKey = "xml";
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("key1", "value1");
			variables.put("key2", "value2");
			ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey,variables);
		}
		
		//办理任务时进行设置
		public void test8() {
			String taskId = "";
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("我要上班了", "我要上班了");
			processEngine.getTaskService().complete(taskId, variables);
		}
		
		//使用runtime的方式进行设置流程变量
		public void test9() {
			String executionId = "";
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("你好", "好");
			processEngine.getRuntimeService().setVariables(executionId, variables);
		}
		
		//使用taskservice的方式进行任务的设置
		public void test10() {
			String taskId = "";
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("你哈", "cb");
			processEngine.getTaskService().setVariables(taskId, variables);
		}
		////////////////////////////////
		
		
		//获取流程变量
		public void test11() {
			String 	executionId = "";
			Map<String , Object> variables = processEngine.getRuntimeService().getVariables(executionId);
			Set<String> keySet = variables.keySet();
		}
		//使用gettask获取
		public void test12() {
			String taskId = "";
			Object variables = processEngine.getTaskService().getVariables(taskId);
			System.out.println(variables);
		}
		
		//创建一个组
		public void test13() {
				Group group = new GroupEntity();
				group.setId("1");
				group.setName("bobo");
				processEngine.getIdentityService().saveGroup(group);
		}
		
		//创建用户
		public void test14() {
			User user = new UserEntity();
			user.setId("2");
			processEngine.getIdentityService().saveUser(user);
		}
		//建立用户和组之间的关系
		public void test15() {
			processEngine.getIdentityService().createMembership("2", "财务组");
		}
		
		//查询组任务
		public void test16() {
			TaskQuery taskQuery = processEngine.getTaskService().createTaskQuery();
			String candidateUser = "2";
			taskQuery.taskCandidateUser(candidateUser);
			List<Task> list = taskQuery.list();
			for(Task task : list){
				System.out.println(task.getId());
			}
		}
		
		//拾取组的任务
		public void test17() {
			String taskId = "";
			processEngine.getTaskService().claim(taskId, "1");
		}
		
		//网关
		
		//启动流程实例 设置流程变量
		public void test18() {
			String processDefinitionKey = "qjdc";
			Map<String,Object> variables = new HashMap<String, Object>();
			variables.put("qjts", 1);
			ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey,variables);
		}
		//办理任务时设置流程变量
		public void test19() {
			String taskId = "";
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("qjts", 2);
			processEngine.getTaskService().complete(taskId,variables);
		}
		
		
		/**
		 * 部署流程定义
		 */
		public void test20() {
			DeploymentBuilder deploymentBuilder = processEngine
					.getRepositoryService().createDeployment();
			deploymentBuilder
					.addClasspathResource("bobo/com/activity/demo1/qjlc.bpmn");
			deploymentBuilder
					.addClasspathResource("bobo/com/activity/demo1/qjlc.png");
			deploymentBuilder.deploy();
		}

		//部署流程定义
		public void test21() {
			DeploymentBuilder deploymentBuilder = processEngine.getRepositoryService().createDeployment();
			deploymentBuilder.addClasspathResource("这里填全路径.bpmn");
			deploymentBuilder.addClasspathResource("图片的全路径.png");
			deploymentBuilder.deploy();
		}
		//启动流程实例设置流程变量
		public void test22() {
			//流程定义key
			String processDefinitionKey = "qjlc";
			Map<String, Object> variables = new HashMap<String,Object>();
			variables.put("qjts", 1);
//			DeploymentBuilder deploymentBuilder = processEngine.getRepositoryService().createDeployment();
			DeploymentBuilder deploymentBuilder = processEngine.getRepositoryService().createDeployment();
			ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey, variables);
			System.out.println(processInstance.getId());
		}
		//办理任务时设置流程变量
		public void test23() {
			String taskId = "2333";//任务的id
			Map<String, Object> variables = new HashMap<String,Object>();
			variables.put("qjts", 2);
			processEngine.getTaskService().complete(taskId);
		}
		/**
		 * 启动流程实例时设置流程变量
		 */
		public void test24() {
			String processDefinitionKey = "qjlc";// 流程定义key
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("qjts", 1);
			ProcessInstance pi = processEngine.getRuntimeService()
					.startProcessInstanceByKey(processDefinitionKey, variables);
			System.out.println(pi.getId());
		}
		
		/**
		 * 办理任务时设置流程变量
		 */
		public void test25() {
			String taskId = "2405";//任务id
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("qjts", 2);
			processEngine.getTaskService().complete(taskId, variables);
		}

}
