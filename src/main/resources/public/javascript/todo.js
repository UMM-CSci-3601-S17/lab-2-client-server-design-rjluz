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
var getIDTodo = function() {
    var text;
    var enterID = prompt("Enter ID below.","58895985a22c04e761776d54");
    var TDHttp = new HttpClient();
    TDHttp.get("/api/todos/" + enterID, function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
}

var limitTodo = function() {
    var text;
    var enterID = prompt("Enter limit below.", 8);
    var TDHttp = new HttpClient();
    TDHttp.get(filterD + "?limit=" + enterID, function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
    if(firstFilt) { filterD = filterD + "?limit=" + enterID; }
    else {filterD = filterD + "&limit=" + enterID;}
    firstFilt = false;
}


var statusTodo = function() {
    var text;
    var enterID = prompt("Enter either complete or incomplete.", "complete");
    var TDHttp = new HttpClient();
    TDHttp.get(filterD + "?status=" + enterID, function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
    if(firstFilt) { filterD = filterD + "?status=" + enterID; }
    else {filterD = filterD + "&status=" + enterID;}
    firstFilt = false;
}

var containsTodo = function() {
    var text;
    var enterID = prompt("Enter text that is located in body of Todo.", "in");
    var TDHttp = new HttpClient();
    TDHttp.get("/api/todos?contains=" + enterID, function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
}

var ownerTodo = function() {
    var text;
    var enterBlanche = prompt("Enter owner.", "Blanche");
    var TDHttp = new HttpClient();
    TDHttp.get("/api/todos?owner=" + enterID, function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
}

var buildCategoryURL = function(category) {
    return "/api/todos?category=" + category;
}

var categoryTodo = function() {
    var text;
    var enterCategory = prompt("Enter category.", "groceries");
    var restURL = buildCategoryURL(enterCategory);

    var TDHttp = new HttpClient();
    TDHttp.get(restURL, function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
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
