package aspects;

import larva.*;
public aspect _asp_alerts0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_alerts0.initialize();
}
}
before () : (call(* *.validLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts0.lock){

_cls_alerts0 _cls_inst = _cls_alerts0._get_cls_alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 738/*login*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 738/*login*/);
}
}
before () : (call(* *.viewAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts0.lock){

_cls_alerts0 _cls_inst = _cls_alerts0._get_cls_alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 740/*viewAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 740/*viewAlerts*/);
}
}
before () : (call(* *.alertCreated(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts0.lock){

_cls_alerts0 _cls_inst = _cls_alerts0._get_cls_alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 742/*createAlert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 742/*createAlert*/);
}
}
before () : (call(* *.alertsDeleted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts0.lock){

_cls_alerts0 _cls_inst = _cls_alerts0._get_cls_alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 744/*deleteAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 744/*deleteAlerts*/);
}
}
before () : (call(* *.statusChanged(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts0.lock){

_cls_alerts0 _cls_inst = _cls_alerts0._get_cls_alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 746/*statusChanged*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 746/*statusChanged*/);
}
}
before () : (call(* *.validLogOut(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts0.lock){

_cls_alerts0 _cls_inst = _cls_alerts0._get_cls_alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 736/*logout*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 736/*logout*/);
}
}
}