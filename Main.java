package racing;

public class Main
{
    public static void main(String[] args)
    {
        //Main_Frame main_frame = new Main_Frame();
        Game_Frame game_frame = new Game_Frame();
        //game_loop(game_frame);
    }

    public static void game_loop(Game_Frame game_frame)
    {
        if(game_frame.label1.getX()==game_frame.label2.getX()||game_frame.label1.getY()==game_frame.label2.getY())
        {
            game_frame.label2.setVisible(false);
            game_frame.label2.setBounds(game_frame.myRandom1(),game_frame.myRandom1(),40,40);
        }
    }
}
