Kimberly Nguyen
D287 Java Frameworks
12/18/23

C
Prompt: Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
File Name: mainscreen.html
Line #: 14
Change: <title>My Bicycle Shop</title> ==> <title>Remi's Cafe</title>
Line #: 19
Change: <h1>Shop</h1> ==> <h1>Menu</h1>
Line #: 21
Change: <h2>Parts</h2> ==> <h2>Items</h2>
Line #: 53
Change: <h2>Products</h2> ==> <h2>Sets</h2>

D
Prompt: Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
File Name: mainscreen.html
Line #: 90-92
Change: Add link to About page
File Name: AboutPageController.java
Line #: 1-20
Change: Add @Controller to AboutPageController class and @GetMapping("/aboutPage") to showAboutPage method, which returns aboutPage.html
File Name: aboutPage.html
Line #: 1-29
Change: Add Our Story header and paragraph. Add link back to main screen.

E
Prompt: Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
File Name: BootStrapData.java
Line #: 37-39
Change: Check if part and product lists are empty before proceeding.
Line #: 41-71
Change: Create OutsourcedParts and save to OutSourcedPartRepository. (Re-used the commented out code)
Line #: 85-94
Change: Create Products and save to ProductRepository. (Re-used the commented out code)

F
Prompt: Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters
        •   The “Buy Now” button must be next to the buttons that update and delete products.
File Name: mainscreen.html
Line #: 83
Change: Buy Now button creating new relative URL "buynow" with product ID as the parameter
        •   The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
File Name: AddProductController.java
Line #: 90-102
Change: Create ProductService object, initialize temp Product reference to the product matching the passed in product ID.
        If the product's inventory is less than 1, redirect to the buynowfail.html
        Else, decerement the product's inventory, save the Product reference using Product Service object, redirect to the buynowsuccess.html
        •   Display a message that indicates the success or failure of a purchase.
File Name: buynowsuccess.html
Line #: 1-15
Change: Successful purchase message.
File Name: buynowfail.html
Line #: 1-15
Change: Failed purchase message.

G
Prompt:
File Name:
Line #:
Change:

H
Prompt:
File Name:
Line #:
Change:

J
Prompt:
File Name:
Line #:
Change:
