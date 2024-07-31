package fr.dawan;

import fr.dawan.models.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        User u = new User();
        //User user = new User(27, "Yanis");
        //User namedUser = new User(18, "Yasmine", "ADEKALOM");
        System.out.println( u.age() );
        User fluentUser = new User().age(27).prenom("Yanis").nom("ADEKALOM");
    }
}
