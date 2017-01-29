##Exploring the Project

1. The git.ignore file is there to ignore files when commiting, in this case some gradle files, .idea for IntelliJ, and nodes for the Karma plugin
2. Purpose of Gradle:  we use gradle to run our website application
3. Purpose of Travis:  for this project it will be used to test the software in github and document it.

## Exploring the server

1. A route in the server code would be a way to get to another page in the website using the / "whatever" command.
2. umm3601.Server class is for storing all the user information and is the layout for the server itself.
3. umm3601.user.UserController is for manipulating the user array with things like sorting by age and such.
4. the users page gives a glimpse of the Json for all the users saved in the server.
5. api/users makes the user page look pretty with JSONview installed in the browser.
6. api/users?age=25 limits the results on the user page to those who are age 25.
7. api/users/588935f5de613130e931ffd5 links to the user id (the really long number thing).
8. The kittens page results in a 404 not found error.  To make it say meow, I just used the route code and made the page spell out "Meow"

## Exploring the client

1. the public folder contains assets(images), css(for style stuff), javascript - about.html(is a page with
info about the website.), index.html(gives the layout of the page), users.html(is the users page with all the user information in JSON), there is also
a javascript file for the users.

2. At the moment there is no way to sort users with the client, you must alter the url.  !?!?!?

3. the client side javascript is the users.js file in the javascript folder.  it is used in the users.html file.



