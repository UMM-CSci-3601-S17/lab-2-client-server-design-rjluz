/**
 * Created by lopez477 on 2/1/17.
 */
window.onload = function() {
    console.log("The page is loaded now!");


    var element = document.getElementById('getAll');
    element.addEventListener("click", getAllTodos, true);

    var element2 = document.getElementById('getID');
    element2.addEventListener("click", getIDTodo, true);

    var element3 = document.getElementById('limitResults');
    element3.addEventListener("click", limitTodo, true);

    var element4 = document.getElementById('status');
    element4.addEventListener("click", statusTodo, true);

    var element5 = document.getElementById('contains');
    element5.addEventListener("click", containsTodo, true);

    var element6 = document.getElementById('owner');
    element6.addEventListener("click", ownerTodo, true);

    var element7 = document.getElementById('category');
    element7.addEventListener("click", categoryTodo, true);
}

var filterD = "/api/todos";
var firstFilt = true;

var HTTPFunction = function(restURL) {
    var TDHttp = new HttpClient();
    TDHttp.get(restURL, function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
}

/**
 * Function to get all the to-dos!
 */
var getAllTodos = function() {
    var TDHttp = new HttpClient();
    TDHttp.get("/api/todos", function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
}

/**
 * Function to to-do by ID
 */
var buildIdURL = function(id) {
    return "/api/todos?id=" + id;
}

var idTodo = function() {
    var text;
    var enterId = prompt("Enter Id.", "58895985a22c04e761776d54");
    var restURL = buildIdtURL(enterId);
    var TDHttp = new HttpClient();
    HTTPFunction(restURL);
}
/*
 * Function to to-do by Limit
 */
var buildLimitURL = function(limit) {
    return "/api/todos?limit=" + limit;
}

var limitTodo = function() {
    var text;
    var enterLimit = prompt("Enter limit.", "8");
    var restURL = buildLimitURL(enterLimit);
    var TDHttp = new HttpClient();
    HTTPFunction(restURL);
}

/**
 * Function to to-do by Status
 */
var buildStatusURL = function(status) {
    return "/api/todos?status=" + status;
}

var statusTodo = function() {
    var text;
    var enterStatus = prompt("Enter status.", "complete");
    var restURL = buildStatusURL(enterStatus);
    var TDHttp = new HttpClient();
    HTTPFunction(restURL);
}

/**
 * Function to to-do by Contains
 */
var buildContainsURL = function(contains) {
    return "/api/todos?contains=" + contains;
}
var containsTodo = function() {
    var text;
    var enterContains = prompt("Enter contains.", "in");
    var restURL = buildContainsURL(enterContains);
    var TDHttp = new HttpClient();
    HTTPFunction(restURL);
}

/**
 * Function to to-do by Owner
 */
var buildOwnerURL = function(owner) {
    return "/api/todos?owner=" + owner;
}
var ownerTodo = function() {
    var text;
    var enterOwner = prompt("Enter owner.", "Blanche");
    var restURL = buildOwnerURL(enterOwner);
    var TDHttp = new HttpClient();
    HTTPFunction(restURL);

}

/**
 * Function to to-do by Category
 * */
var buildCategoryURL = function(category) {
    return "/api/todos?category=" + category;
}

var categoryTodo = function() {
    var text;
    var enterCategory = prompt("Enter category.", "groceries");
    var restURL = buildCategoryURL(enterCategory);
    var TDHttp = new HttpClient();
    HTTPFunction(restURL);
}


function HttpClient() {
    // We'll take a URL string, and a callback function.
    this.get = function(aUrl, aCallback){
        var anHttpRequest = new XMLHttpRequest();

        // Set a callback to be called when the ready state of our request changes.
        anHttpRequest.onreadystatechange = function(){

            /**
             * Only call our 'aCallback' function if the ready state is 'DONE' and
             * the request status is 200 ('OK')
             *
             * See https://httpstatuses.com/ for HTTP status codes
             * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
             *  for XMLHttpRequest ready state documentation.
             *
             */
            if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
                aCallback(anHttpRequest.responseText);
        }

        anHttpRequest.open("GET", aUrl, true);
        anHttpRequest.send(null);
    }
}
