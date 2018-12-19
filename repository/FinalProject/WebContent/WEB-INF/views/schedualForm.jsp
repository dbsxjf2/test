<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<div id="wrap">
<section class=" kt-pt-180">
        <div class="container">
            <div class="row" ng-app="app" ng-controller="calendarCtrl">
                <input type="hidden" ng-init="courseType='WORKTRAINEE'" value="WORKTRAINEE" ng-model="courseType" ng-value="courseType">
                <div class="col-md-3">
                    <div class="hpanel panel-group">
                        <div class="panel-body">
                            <span class="label label-default">Today</span>
                            <h4 class="font-light">
                                2018.12.14 (�ݿ���)
                            </h4>
                            <h5><i class="fa fa-info-circle"></i> ������ ������ ������ ������ �޷¿� ǥ�õ˴ϴ�.<h5>
                        </div>
                        
                        <div class="panel-body">
                            <h5>������ ���� ����</h5>
                            <ul class="topicBox-list">
                                
                                    <li>
                                        <span ng-class="{active:topicId == '4'}" ng-click="changeTopic(4)" >
                                            <i class="fa fa-square" style="color: #AA12B2;"></i> �濵/����Ͻ�
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '5'}" ng-click="changeTopic(5)" >
                                            <i class="fa fa-square" style="color: #AA4319;"></i> ������/EA
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '22'}" ng-click="changeTopic(22)" >
                                            <i class="fa fa-square" style="color: #E3F3EB;"></i> SW����
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '23'}" ng-click="changeTopic(23)" >
                                            <i class="fa fa-square" style="color: #48B4EC;"></i> ����Ͻ� �м�(BA)
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '32'}" ng-click="changeTopic(32)" >
                                            <i class="fa fa-square" style="color: #ACF2E6;"></i> SOA	
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '8'}" ng-click="changeTopic(8)" >
                                            <i class="fa fa-square" style="color: #244B43;"></i> ����
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '10'}" ng-click="changeTopic(10)" >
                                            <i class="fa fa-square" style="color: #82A943;"></i> DB
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '11'}" ng-click="changeTopic(11)" >
                                            <i class="fa fa-square" style="color: #216C93;"></i> ���α׷���
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '21'}" ng-click="changeTopic(21)" >
                                            <i class="fa fa-square" style="color: #0A5CBD;"></i> �����
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '26'}" ng-click="changeTopic(26)" >
                                            <i class="fa fa-square" style="color: #C4B85B;"></i> �Ӻ����
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '25'}" ng-click="changeTopic(25)" >
                                            <i class="fa fa-square" style="color: #177D37;"></i> IoT
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '15'}" ng-click="changeTopic(15)" >
                                            <i class="fa fa-square" style="color: #6B14ED;"></i> Ŭ����
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '19'}" ng-click="changeTopic(19)" >
                                            <i class="fa fa-square" style="color: #18D48C;"></i> ������
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '27'}" ng-click="changeTopic(27)" >
                                            <i class="fa fa-square" style="color: #8D7734;"></i> ������
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '14'}" ng-click="changeTopic(14)" >
                                            <i class="fa fa-square" style="color: #32FFDE;"></i> �ΰ�����(AI)
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '9'}" ng-click="changeTopic(9)" >
                                            <i class="fa fa-square" style="color: #B31B41;"></i> SW�׽�Ʈ
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '20'}" ng-click="changeTopic(20)" >
                                            <i class="fa fa-square" style="color: #866C46;"></i> SW����/����
                                        </span>
                                    </li>
                                
                            </ul>
                        </div>
                        
                    </div>
                </div>
                <div class="col-md-9 kt-pt-20">
                    <a class="btn w-xs  btn-primary" href="/lectures/cal?courseType=WORKTRAINEE">������ ����</a>  <a class="btn w-xs  btn-default" href="/lectures/cal?courseType=TRAINEE">ä�뿹���� ����</a>

                    <div class="hpanel kt-pt-40">
                        <div ui-calendar="uiConfig.calendar" ng-model="eventSources" calendar="myCalendar" ></div>
                    </div>
                </div>
            </div>
		</div>
	</section>
</div>