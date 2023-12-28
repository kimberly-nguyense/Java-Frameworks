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
Prompt: •   The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
File Name: AddProductController.java
Line #: 90-102
Change: Create ProductService object, initialize temp Product reference to the product matching the passed in product ID.
        If the product's inventory is less than 1, redirect to the buynowfail.html
        Else, decerement the product's inventory, save the Product reference using Product Service object, redirect to the buynowsuccess.html
Prompt: •   Display a message that indicates the success or failure of a purchase.
File Name: buynowsuccess.html
Line #: 1-15
Change: Successful purchase message.
File Name: buynowfail.html
Line #: 1-15
Change: Failed purchase message.

G
Prompt: Modify the parts to track maximum and minimum inventory by doing the following:
        •   Add additional fields to the part entity for maximum and minimum inventory.
File Name: Part.java
Line #: 31-34, 56-63
Change: Add int minInv, int maxInv fields to Part entity. Add constructor including minInv and maxInv fields.
Prompt: •   Modify the sample inventory to include the maximum and minimum fields.
File Name: BootStrapData.java
Line #: 65-66, 77-78, 91-92, 105-106
Change: Add minInv, maxInv values to each sample inventory part.
Prompt: •   Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
File Name: InhousePartForm.html, OutsourcedPartForm.html
Line #: 24-27 (both)
Change: Add text input for minInv and maxInv
Prompt: •   Rename the file the persistent storage is saved to.
File Name: application.properties
Line #: 6
Change: Changed file name to spring-boot-h2-db-d287 and changed path to new file name.
Prompt: •   Modify the code to enforce that the inventory is between or at the minimum and maximum value.
File Name: Part.java, ValidInv.java, InvValidator.java
Line #: 20; 1-18; 1-33
Change: To Part class, add Custom Validator @ValidInv, validated by class InvValidator. Validates Part if inventory is between or at the minimum and maximum value.

H
Prompt: H. Add validation for between or at the maximum and minimum fields. The validation must include the following:
        •   Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
File Name:
Line #:
Change:
Prompt: •   Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
File Name: ValidEnufParts.java, EnufPartsValidator.java
Line #: 20; 36-38
Change: Updated error message to be more specific. Updated validator to check if parts can still meet minimum requirements.
Prompt: •   Display error messages when adding and updating parts if the inventory is greater than the maximum.
File Name:
Line #:
Change:

I
Prompt: Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
File Name:
Line #:
Change:

J
Prompt: Remove the class files for any unused validators in order to clean your code.
File Name: DeletePartValidator.java
Change: Deleted file because it wasn't ever used.