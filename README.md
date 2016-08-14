COMP204-16B / COMP242-16B Assignment 3
======================================

Due on **Sunday, 14th August at 11:30pm**.


Experimenting with a big Java Package – JavaFX
==============================================

The goal of this exercise is learn about the JavaFX system for building user interfaces.
JavaFX is the recommended library for making user interfaces in desktop applications with 
Java 8 (the current version of the Java language and development system).

JavaFX is described in the [documentation supplied by Oracle, found here](http://docs.oracle.com/javase/8/).

This assignment is comprised of 3 parts:
 1. Writing a basic "Hello World" JavaFX program guided by documentation
 2. Creating a basic form using JavaFX guided by documentation
 3. Beginning a more complex project that leverages what you learned in the first two parts
 
**You will update this document as part of the tasks.**


Preamble
========

1. Fork this repository using the button at the top of the page.
  * Set the visibility level of the project to Private.
2. Clone your new repository to your computer using Git.
3. Remember to commit and push regularly!


Task 1
======

To begin, open the JavaFX\_Hello\_World project with your IDE and the [JavaFX Hello World tutorial, found here](https://docs.oracle.com/javase/8/javafx/get-started-tutorial/hello_world.htm) in a browser.

* Work through the Hello World code and implement it in your project. Resist the temptation to copy and paste the code from the tutorial page, it will help to type it out by hand.
* Come up with three questions you have about your solution and detail them below. These questions should be different to those covered during the lectures.
* Modify your solution to attempt to answer your questions. Update your questions below to indicate how you went about answering the question and what the answer was.

Task 1 Questions
----------------

```
I come from using Visual Stuido in which we basically dragged and droped UI items (buttons, textfields)
so it was very strange not seeing anything that was drag and drop, my first impression was, 
maybe you cant do it (stupied thought I know) 

When working with this task, there seemed to be alot of code for such a simple task and was quite 
over whelming.To think I would have to write that much code just to add a button on a window, 
but as working through the code it kind of made some sense. 

These are the few questions that were raised in my head while working through.

1)
What are the capabilities of this new GUI library, can it even do much for develpers, what are the possibilites ?
Since I personally felt the drag and drop on visual studio was alot easier, quicker (probably because I am very new/ unfamilier)
After some googleing there are few of the features that stood out to me. 
    * JavaFX is more powerful/faster then Swing, it can be used for desktop and web applications.
    * JavaFX Scene Builder provided by Orcale which makes it alot easier to move around buttons, etc ( I just learnt this, and all this time I thought there was no way moving the buttons except using code)
    * You can apply CSS on components(Buttons,etc). 
    * You can easily add sound, images & sound in javafx. 
    * It has high performance media engine which supports the playback of web multimedia conent.  
    
    Source : http://docs.oracle.com/javafx/2/overview/jfxpub-overview.htm
    Source : https://www.youtube.com/watch?v=9YrmON6nlEw&list=PLS1QulWo1RIaUGP446_pWLgTZPiFizEMq
        
2) 
From looking around what are the capabilities of JavaFX I came across a page which had the best practices for JavaFx, one of them being "Use a Custome Preloader"
So my question is What is a Preloader ? 
To me that sounds like somthing that happens before your program is loaded and presented to you. 
    * A Preloader is a program which is seprate from your main proagram that runs while you main program is starting up.
    * So if you imagine a bike on a racetrack, and its going from its start to finish. 
    * Thats a preloader, your bike is working like a progress bar for how much of your application is loaded. 
    * Preloaders are not used for applications that load quickly.
    * They are mainly useed when the program is going to wait sometime waiting for the program. 
    
    Source : http://docs.oracle.com/javafx/2/best_practices/jfxpub-best_practices.htm 

3)
Is there somthing like MessageBox from visual studio in this new GUI ? 
For example when I have google calender open on chrome and I have got a class soon it will alerts me by having a mini message box.
After some research it turns out you can do this, by simply having another class which creates another window that you can display your message or even make it so that user cant acces other window until they close the message box.
  
   * Create a class (B), Make a window and add a label in that window.
   * To make it so user cant acceess other window until they close message box. Use "Box.initModality(Modality.APPLICATION_MODAL);" "Box" being the stage name. 
   * Also use "window.showAndWait() instead of window.show()" which waits for message window to close before continueing on with code.
   * Create a window just like we did with HelloWorld.
   * Create a class (A), Make a window and add a button which will have a action event that will cause class(B) to excute. 
  
  The solution being this simple kind of makes me feel stupied since it didnt even pop into my head but learning how you can restrict the access to user to main window while message box is up was quite intresting. I can think of many uses for this, 
  such as if my program need time to load somthing I could set a timer on a message box which displays "Please Wait" and restrict acces to main window until my program is finished.  
   
   Source : https://www.youtube.com/watch?v=SpL3EToqaXA 

```

Task 2
======

To begin, open the JavaFX\_Form\_Design project with your IDE and the [JavaFX Form Creation tutorial, found here](https://docs.oracle.com/javase/8/javafx/get-started-tutorial/form.htm) in a browser.

* Work through the tutorial and implement it in your project. Resist the temptation to copy and paste the code from the tutorial page, it will help to type it out by hand.
* Come up with three questions you have about your solution and detail them below. **These questions should differ from those used in Task 1**.
* Modify your solution to attempt to answer your questions. Update your questions below to indicate how you went about answering the question and what the answer was.

Task 2 Questions
----------------

```

1) Could I generate textboxes with a loop and have them stored in a array at the same time ?
   Doing project (Task3) I created every indiviual TextBox by hand, now thinking about it, if I had could use a loop it would've saved clutterness and time.
   
   * Just realized that password text box is type "PasswordField" where username is a "TextBoxField". First thought was an TextField array probably wont accept a PasswordField type. But I experimented with it anyways and it seemed to just work fine. 
   * TextField & PasswordField must be linked in some way. After some research it turns out PasswordField is one of the direct known subclasses of TextField.
   * This would work alot better If all fields were textfields like in project but offsetting might not work as well, since you got to think what will happen in a loop in complex situations. 
   * Implementing this feature in here did not make that much of a diffrence but if I implement this into my project, it would save alot of space espcially since we didnt have to size textfields.
   * From this I presume this could be also done with labels, you could create alot of them and then custimize them to your needs when you needed to use them. It would save all the initilzing everytime you used it. 
   
   Source:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html
   
2) Could I do somthing before the user closes my program ?
   * My first thought was this is a stupied question, because why would you need to do anything since the user is closing program ?
   * But then I realized that some programs might need to save the users data from the textfields.
   * I found out that when user closes program I can call a method before it closes.
   * So I can get all the information out of the textboxes and write them to a text document before exiting or even warn the user if they are sure they want to exit.
   
  Source : https://www.youtube.com/watch?v=ZuHcl5MmRck

3) Could I Make programs, forms/ programs that look nice and not simply grey and black ? 
   So far doing programs in Vistual Studio they were pretty plane, with occasional plain color. I wonder If in javafx you could make a program look nicer/ professional. 
   
   * Turns out you can use Cascading Style Sheets (.css) to custimize your programs, I personally thought css was only used with html so this is a bit of suprise for me. 
   * It is basically just implemented like you implement css in html.
   * You create a new file with .css extention (in src folder where you code is). 
   * if I want to target all the labels in my program/class, I use .label in my css to target them and from then on I can set all of there properties. (background colors, background radius, etc)
   * Also this implies with buttons, using the same method we just did for our label. 
   * Now obviously we can also target buttons, labels individually using button.getStyleClass().add("you unqie name from css");
   
   From this you can really be creative with your program, make it more apealing, easier to detect important parts. Get the user to look where you want them to look first. 
   
   Source : http://docs.oracle.com/javafx/2/best_practices/jfxpub-best_practices.htm 
   Source : https://www.youtube.com/watch?v=MAiKpkQqb6Q 
```

Task 3
======

In the JavaFX\_Project project, write an application that takes a list of 3 products, quantities and unit costs; and produces a receipt reflecting that information.  
In addition, the generated receipt prices should be editable. A mockup of what you will be building is shown below.

![Example interface](images/project.PNG)

You will need to split the window into halves. On the left-hand side you should
have 3 rows of 3 input fields. These fields should allow for setting a product
name, quantity and unit cost for each row. On the right you should have a 
non-editable representation of each row's product name and quantity, and an 
editable field that contains the total cost for that row.  Also on the 
right-hand side there should be a non-editable total field that contains the sum
of the totals on the right side.

When a field on the left-hand side is modified, the appropriate fields on the right-hand
side should be updated. This will involve copying the product name and quantity to 
the non-editable fields, and calculating the row cost by multiplying the unit cost 
by quantity then updating the editable cost field to display this value. When the 
right-hand editable fields change, the total field should also be updated.


Submission
==========

Upload a zipped copy of your repository to [moodle in the assignment submission](https://elearn.waikato.ac.nz/mod/assign/view.php?id=566698). 
Please download the zip from GitLab using the download button in the top right 
of the project view rather than zipping it from the copy on your local hard drive.


Grading
=======

| Weighting | Allocated to |
|:----------:|------|
| 10% | Correct repository usage and settings |
| 20% | Task 1 code, questions and modifications |
| 20% | Task 2 code, questions and modifications |
| 40% | Task 3 implementation |
