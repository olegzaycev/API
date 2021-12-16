package bo;

import api_content.Client;
import api_content.Request;
import api_content.RequestToTrello;
import api_content.Response;
import io.qameta.allure.Step;
import org.json.JSONArray;
import org.testng.Assert;


public class Trello {
    @Step("CreateBoard")
    public String CreateBoard(String name) {
        Request request = RequestToTrello.createBoard(name);
        Response response = new Client().send(request);
        Assert.assertEquals(response.getStatusCode().intValue(), 200, "Invalid code");
        return response.getBodyAsJson().getString("id");
    }
    @Step("createCard")
    public Response createCard(String IdBoard, int ChooseColumn, String nameCard) {

        String ListOfColumns = getListOfColumns(IdBoard).getJSONObject(ChooseColumn).get("id").toString();
        Request req = RequestToTrello.createCard(ListOfColumns, nameCard);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(), 200, "invalid code");
        return res;
    }
    @Step("deleteBoard")
    public Response deleteBoard(String boardId) {


        Request request = RequestToTrello.deleteBoard(boardId);
        Response response = new Client().send(request);
        Assert.assertEquals(response.getStatusCode().intValue(), 200, "invalid code");
        return response;
    }
    @Step("getListOfColumns")
    public JSONArray getListOfColumns(String boardId) {
        Request req = RequestToTrello.listIdsTrelloBoard(boardId);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
        return new JSONArray(res.getBody());
    }
    @Step("updateBoard")
    public Response updateBoard(String boardId,String name,String desc,String color) {
        Request req = RequestToTrello.updateInfoTrelloBoard(boardId,name,desc,color);
        Response res=new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
        return res;
    }
    @Step("moveCard")
    public Response moveCard(String idBoard,int FromColumn,int ChooseCard,int ToColumn) {


        JSONArray ListOfColumns = getListOfColumns(idBoard);
        String idColumn = ListOfColumns.getJSONObject(FromColumn).get("id").toString();
        String idCard = getCardFromListOfColumn(idColumn).getJSONObject(ChooseCard).get("id").toString();
        idColumn = ListOfColumns.getJSONObject(ToColumn).get("id").toString();


        Request req = RequestToTrello.moveCardTrello(idCard, idColumn);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
        return res;
    }
    @Step("getCardFromListOfColumn")
    public JSONArray getCardFromListOfColumn(String IdList) {
        Request req = RequestToTrello.getCardIdsByListTrello(IdList);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
        return new JSONArray(res.getBody());
    }



}
