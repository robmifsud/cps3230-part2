package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_alerts0 implements _callable{

public static PrintWriter pw; 
public static _cls_alerts0 root;

public static LinkedHashMap<_cls_alerts0,_cls_alerts0> _cls_alerts0_instances = new LinkedHashMap<_cls_alerts0,_cls_alerts0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\rober\\workspace\\Task2/src/output_alerts.txt");

root = new _cls_alerts0();
_cls_alerts0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_alerts0 parent; //to remain null - this class does not have a parent!
int no_automata = 2;
 public int alertCount =0 ;
 public boolean loginStatus =false ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_alerts0() {
}

public void initialisation() {
}

public static _cls_alerts0 _get_cls_alerts0_inst() { synchronized(_cls_alerts0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_alerts0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_alerts0_instances){
_performLogic_logins(_info, _event);
_performLogic_alerts(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_alerts0[] a = new _cls_alerts0[1];
synchronized(_cls_alerts0_instances){
a = _cls_alerts0_instances.keySet().toArray(a);}
for (_cls_alerts0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_alerts0_instances){
_cls_alerts0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_logins = 291;

public void _performLogic_logins(String _info, int... _event) {

_cls_alerts0.pw.println("[logins]AUTOMATON::> logins("+") STATE::>"+ _string_logins(_state_id_logins, 0));
_cls_alerts0.pw.flush();

if (0==1){}
else if (_state_id_logins==290){
		if (1==0){}
		else if ((_occurredEvent(_event,746/*statusChanged*/))){
		loginStatus =!loginStatus ;
_cls_alerts0.pw .println ("Login Status changed, new status: "+loginStatus );

		_state_id_logins = 290;//moving to state loggedIn
		_goto_logins(_info);
		}
		else if ((_occurredEvent(_event,736/*logout*/)) && (loginStatus ==false )){
		
		_state_id_logins = 291;//moving to state loggedOut
		_goto_logins(_info);
		}
		else if ((_occurredEvent(_event,740/*viewAlerts*/))){
		
		_state_id_logins = 290;//moving to state loggedIn
		_goto_logins(_info);
		}
		else if ((_occurredEvent(_event,736/*logout*/)) && (loginStatus ==true )){
		_cls_alerts0.pw .println ("Bad State! Last status was "+loginStatus );

		_state_id_logins = 289;//moving to state badState
		_goto_logins(_info);
		}
}
else if (_state_id_logins==291){
		if (1==0){}
		else if ((_occurredEvent(_event,746/*statusChanged*/))){
		loginStatus =!loginStatus ;
_cls_alerts0.pw .println ("Login Status changed, new status: "+loginStatus );

		_state_id_logins = 291;//moving to state loggedOut
		_goto_logins(_info);
		}
		else if ((_occurredEvent(_event,738/*login*/)) && (loginStatus ==true )){
		
		_state_id_logins = 290;//moving to state loggedIn
		_goto_logins(_info);
		}
		else if ((_occurredEvent(_event,738/*login*/)) && (loginStatus ==false )){
		_cls_alerts0.pw .println ("Bad State! Last status was "+loginStatus );

		_state_id_logins = 289;//moving to state badState
		_goto_logins(_info);
		}
		else if ((_occurredEvent(_event,740/*viewAlerts*/))){
		_cls_alerts0.pw .println ("Bad State! Last status was "+loginStatus );

		_state_id_logins = 289;//moving to state badState
		_goto_logins(_info);
		}
}
}

public void _goto_logins(String _info){
_cls_alerts0.pw.println("[logins]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_logins(_state_id_logins, 1));
_cls_alerts0.pw.flush();
}

public String _string_logins(int _state_id, int _mode){
switch(_state_id){
case 289: if (_mode == 0) return "badState"; else return "!!!SYSTEM REACHED BAD STATE!!! badState "+new _BadStateExceptionalerts().toString()+" ";
case 290: if (_mode == 0) return "loggedIn"; else return "loggedIn";
case 291: if (_mode == 0) return "loggedOut"; else return "loggedOut";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}
int _state_id_alerts = 295;

public void _performLogic_alerts(String _info, int... _event) {

_cls_alerts0.pw.println("[alerts]AUTOMATON::> alerts("+") STATE::>"+ _string_alerts(_state_id_alerts, 0));
_cls_alerts0.pw.flush();

if (0==1){}
else if (_state_id_alerts==294){
		if (1==0){}
		else if ((_occurredEvent(_event,742/*createAlert*/))){
		alertCount ++;

		_state_id_alerts = 294;//moving to state moreThan5
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,744/*deleteAlerts*/))){
		alertCount =0 ;

		_state_id_alerts = 295;//moving to state empty
		_goto_alerts(_info);
		}
}
else if (_state_id_alerts==295){
		if (1==0){}
		else if ((_occurredEvent(_event,742/*createAlert*/))){
		alertCount ++;

		_state_id_alerts = 293;//moving to state lessThanOr5
		_goto_alerts(_info);
		}
}
else if (_state_id_alerts==293){
		if (1==0){}
		else if ((_occurredEvent(_event,742/*createAlert*/)) && (alertCount <5 )){
		alertCount ++;

		_state_id_alerts = 293;//moving to state lessThanOr5
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,742/*createAlert*/)) && (alertCount >=5 )){
		alertCount ++;

		_state_id_alerts = 294;//moving to state moreThan5
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,744/*deleteAlerts*/))){
		alertCount =0 ;

		_state_id_alerts = 295;//moving to state empty
		_goto_alerts(_info);
		}
}
}

public void _goto_alerts(String _info){
_cls_alerts0.pw.println("[alerts]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_alerts(_state_id_alerts, 1));
_cls_alerts0.pw.flush();
}

public String _string_alerts(int _state_id, int _mode){
switch(_state_id){
case 292: if (_mode == 0) return "badState"; else return "!!!SYSTEM REACHED BAD STATE!!! badState "+new _BadStateExceptionalerts().toString()+" ";
case 294: if (_mode == 0) return "moreThan5"; else return "moreThan5";
case 293: if (_mode == 0) return "lessThanOr5"; else return "lessThanOr5";
case 295: if (_mode == 0) return "empty"; else return "empty";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}