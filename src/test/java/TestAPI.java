import  bo.Trello;
import org.testng.annotations.Test;

public class TestAPI {
    Trello trello = new Trello();


    @Test
    public void CreateBoard()
    {
        trello.CreateBoard("Wsaaa");
    }
    @Test
    public void CreateCard()
    {
        trello.createCard("imtH3LAw",0,"re");
    }
    @Test
    public void MoveCardToDone()
    {
        trello.moveCard("imtH3LAw",0,0,1);
    }
    @Test
    public void UpdateBoard()
    {
        trello.updateBoard("imtH3LAw","NameDone","DeskDone","pink");
    }
    @Test
    public void DeleteBoard() {
        trello.deleteBoard("imtH3LAw");
    }

}
