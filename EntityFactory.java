package assignment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//i Take reference from google to get information of syntax and their way of using;
//and I have watched videos for design patterns & Mapping;
public class EntityFactory {
	 Map<String,Class> Map = new HashMap<String,Class>();
	private static Class[] Entity = {Plane.class, Sphere.class, Cone.class};
    EntityFactory(){
    	for(int i=0; i<Entity.length; i++) {
    		Map.put(Entity[i].getName(), createClass(Entity[i]));
    	}
    }
	 
	private Class createClass(Class class1) {
		if(class1.getDeclaredClasses().length == 1) {
			return class1.getDeclaredClasses()[0];
		}else {
		return null;
	}}

	public static EntityFactory get() {
		// TODO Auto-generated method stub
		return new EntityFactory();
	}

	public Entity create(String string) {
		Class object = this.Map.get(Classname(string)[0]);
        List<Object> parameter= createItems(object.getTypeName(), Classname(string)[1]);
		return null;		  
	}

	private List<Object> createItems(String typeName, Object object) {
		String[] parameter = typeName.split(" ,+");
		parameter[0] = parameter[0].substring(1);
		parameter[parameter.length-1]=parameter[parameter.length-1].substring(0, parameter[parameter.length-1].length()-1);
		for(int i=0; i<parameter.length; i++) {
			if(parameter[i].charAt(0) == ' ') {
				parameter[i] =parameter[i].substring(1);
			}else {
				parameter[i] =parameter[i];
			}
		}
		List<Object> selection =new ArrayList<Object>();
		for(int i=0; i<Entity.length; i++) {
			if(Entity[i].getName().matches("Vec3D")) {
				selection.add(new Vec3D(parameter[i]));
			}if(Entity[i].getName().matches("Float")) {
				selection.add(Float.parseFloat(parameter[i]));
			}if(Entity[i].getName().matches("double")) {
				selection.add(Double.parseDouble(parameter[i]));
			}		
		}
		return selection;
	}

	private Object[] Classname(String string) {
		while(string.contains(" ")) {
			string = string.substring(0,string.indexOf(" ")+1)+string.substring(string.indexOf(" ")+2);	}
		String[] object = string.split(" ", 2);		
		return object;
	}	
	}

