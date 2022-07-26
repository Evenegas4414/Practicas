package Clases.Enumerados;

public class CommandWordTest {
    public static void main(String[] args) {

        System.out.println(CommandWord.GO.getClass());
        CommandWord GO1 = CommandWord.GO;
        CommandWord GO2 = CommandWord.GO;

        System.out.println(GO1);
        System.out.println(CommandWord.GO);
    }
}
