Aim:

To containerize a Java application LoginApp.java that accepts username and password, and prints
“Login Successful” if credentials match predefined values, otherwise prints “Access Denied.”
To build a Docker image, run the container, and analyze if any issues occur during build or runtime.


---

Program & Steps:

1. Create Files

(a) LoginApp.java
Write your Java code as shown below:

import java.util.Scanner;

public class LoginApp {
    public static void main(String[] args) {
        String predefinedUsername = "admin";
        String predefinedPassword = "1234";

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (username.equals(predefinedUsername) && password.equals(predefinedPassword))
            System.out.println("Login Successful");
        else
            System.out.println("Access Denied");
    }
}

(b) Dockerfile
Create a Dockerfile with the following content:

FROM openjdk:17-alpine
WORKDIR /app
COPY LoginApp.java .
RUN javac LoginApp.java
CMD ["java", "LoginApp"]


---

2. Build the Docker Image

Create a folder named loginapp and add both files (LoginApp.java and Dockerfile) inside it.

In the terminal, go to this folder:

cd loginapp

Run the build command:

docker build -t login-app .

Here,
-t → tag name for the image
. → current directory (build context)


---

3. Run the Docker Container

Run the container in interactive mode (because input is required):

docker run --rm -it login-app

Expected Output:

Enter username: admin
Enter password: 1234
Login Successful

If wrong credentials are entered:

Access Denied


---

4. Errors / Troubleshooting & Fixes

Error 1:

error: file not found: LoginApp.java

Reason: File not in same directory as Dockerfile or incorrect name.
Fix: Ensure both files are in the same folder and named correctly.


---

Error 2:

Error: Could not find or load main class LoginApp

Reason: Wrong CMD or package name used.
Fix: Use

CMD ["java", "LoginApp"]

and ensure no package is declared in the Java file.


---

Error 3:
Program waits for input but doesn’t respond.
Reason: Container not started in interactive mode.
Fix: Use -it with docker run to allow terminal input.


---

5. Output:

✅ When correct credentials (admin / 1234) entered:

Login Successful

❌ When wrong credentials entered:

Access Denied


---

6. Result:

Successfully created a Docker image and containerized the LoginApp.java program.
The container executes properly and displays “Login Successful” for correct credentials and “Access Denied” otherwise.
