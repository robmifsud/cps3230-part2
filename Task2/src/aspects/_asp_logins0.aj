package aspects;

import larva.*;
public aspect _asp_logins0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_logins0.initialize();
}
}
before () : (call(* *.goodLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_logins0.lock){

_cls_logins0 _cls_inst = _cls_logins0._get_cls_logins0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 68/*goodLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 68/*goodLogin*/);
}
}
before () : (call(* *.badLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_logins0.lock){

_cls_logins0 _cls_inst = _cls_logins0._get_cls_logins0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 66/*badLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 66/*badLogin*/);
}
}
before ( boolean locked) : (call(* *.setLocked(..)) && args(locked) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_logins0.lock){

_cls_logins0 _cls_inst = _cls_logins0._get_cls_logins0_inst();
_cls_inst.locked = locked;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 70/*unlockAccount*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 70/*unlockAccount*/);
}
}
}