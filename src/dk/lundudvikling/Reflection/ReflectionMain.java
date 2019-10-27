package dk.lundudvikling.Reflection;

import java.lang.reflect.*;

public class ReflectionMain {

    public static void main(String[] args){
        Class reflectClass = UFOEnemyShip.class;


        String className = reflectClass.getSimpleName();
        System.out.println(className);

        int classModifier = reflectClass.getModifiers();
        System.out.println(Modifier.isPublic(classModifier));

        Class[] interfaces = reflectClass.getInterfaces();
        Class classSuper = reflectClass.getSuperclass();
        System.out.println(classSuper.getSimpleName());

        Method[] classMethods = reflectClass.getMethods();

        for (Method method : classMethods){
            System.out.println("method: " + method.getName());

            if (method.getName().startsWith("get")){
                System.out.println("Getter method");
            }else if (method.getName().startsWith("set")){
                System.out.println("Setter method");
            }
        }

        Object constructor = null;
        try {
            constructor = reflectClass.getConstructor(int.class, String.class).newInstance(12,"Random String");
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Field privateStringName = null;
        UFOEnemyShip enemyShipPrivate = new UFOEnemyShip(12, "123");

        try {
            String idCodeString = "idCode";
            privateStringName = UFOEnemyShip.class.getDeclaredField(idCodeString);
            privateStringName.setAccessible(true);
            String value = (String)privateStringName.get(enemyShipPrivate);
            //Private field
            System.out.println(value);

            String methodName = "getPrivate";
            Method privateMethod = UFOEnemyShip.class.getDeclaredMethod(methodName, null);

            privateMethod.setAccessible(true);

            String privateReturnValue = (String) privateMethod.invoke(enemyShipPrivate, null);
            System.out.println(privateReturnValue);

            Class[] methodParameters = new Class[]{Integer.TYPE, String.class};

            Object[] params = new Object[]{10, "Random"};

            privateMethod = UFOEnemyShip.class.getDeclaredMethod("getOtherPrivate", methodParameters);

            privateMethod.setAccessible(true);

            privateReturnValue = (String) privateMethod.invoke(enemyShipPrivate, params);

            System.out.println(privateReturnValue);


        } catch (NoSuchFieldException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
