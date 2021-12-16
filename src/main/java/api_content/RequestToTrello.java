package api_content;

public class RequestToTrello {
    public static Request getPostman() {
        Request request = new Request();
        request.setProtocol("https");
        request.setHost("postman-echo.com");
        request.setPath("get");
        request.setMethod("GET");
        return request;
    }

    private static Request baseTrelloRequest() {
        Request request = new Request();
        request.setProtocol("https");
        request.setHost("api.trello.com");
        return request;
    }

    private final static String KEY = "788ce1a802bd0530d77bed0df0712f2f";
    private final static String TOKEN   = "83338a15adf11be8975c27d6d6317688f1b993f925ac74f65321a4ed3236ce00";

    public static Request createBoard(String boardName) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/?name="+ boardName+ "&defaultLists=false&key="+ KEY + "&token=" + TOKEN);
        request.setMethod("POST");
        return request;
    }
    public static Request createCard(String idList, String nameCart) {
        Request request=baseTrelloRequest();
        request.setPath("1/cards?idList=" + idList + "&name=" + nameCart + "&key="+ KEY + "&token="+ TOKEN);
        request.setMethod("POST");
        return request;
    }
    public static Request deleteBoard(String boardId) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/"+boardId+"?key=" + KEY + "&token=" + TOKEN);
        request.setMethod("DELETE");
        return request;
    }
    public static Request listIdsTrelloBoard(String boardId) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/" + boardId + "/lists?key="+KEY + "&token="+TOKEN);
        request.setMethod("GET");
        return request;
    }
    public static Request updateInfoTrelloBoard(String boardId, String new_name,String new_desc,String new_color) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/"+boardId+"?name="+new_name+"&desc="+new_desc+"&prefs/background="+new_color+"&key=" + KEY + "&token=" + TOKEN);
        request.setMethod("PUT");
        return request;
    }
    public static Request moveCardTrello(String idCart, String newIdList) {
        Request request=baseTrelloRequest();
        request.setPath("1/cards/" + idCart + "?idList=" + newIdList + "&key="+ KEY + "&token="+ TOKEN);
        request.setMethod("PUT");
        return request;
    }
    public static Request getCardIdsByListTrello(String idList) {
        Request request=baseTrelloRequest();
        request.setPath("1/lists/" + idList + "/cards?key="+ KEY + "&token="+ TOKEN);
        request.setMethod("GET");

        return request;
    }

}
