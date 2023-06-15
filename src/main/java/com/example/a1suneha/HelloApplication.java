//Suneha
//Gursharan  Tatla
// 12-06-2023
// This code is based on ATM machine which prompt user to see their account information. it also enable user to deposit or withdraw any amount .
// package com.example.a1suneha;


        package com.example.a1suneha;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Date;

public class HelloApplication  extends Application {

    private Account[] accounts;//array to store multiple accounts

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

       accounts = new Account[10];//created an array
        //Create ten accounts in an array with id 0, 1, . . ., 9, and initial balance $100.
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i, 100.0);
        }

        // Created JavaFX components
        Label idLabel = new Label("Enter correct Account ID:");//prompt the user to enter a correct account id
        TextField idTextField = new TextField();// a text field where the user can enter an account id.
        Button Button = new Button("Fetch Account");//button to fetch the account from an array
        Label accountLabel = new Label();//to display fetches account id
        Label balanceLabel = new Label();//to display fetch account balance
        Label dateCreatedLabel = new Label();//to display the date
        Label depositLabel = new Label("Deposit Amount:");//prompt the user to enter a deposit amount
        TextField depositTextField = new TextField();//textfield where the user can enter a deposit amount
        Button depositButton = new Button("Deposit");//button to deposit the amount
        Label withdrawLabel = new Label("Withdraw Amount:");//prompt user to enter a withdrawal amount
        TextField withdrawTextField = new TextField();//textfield where the user can enter a withdrawal amount
        Button withdrawButton = new Button("Withdraw");//button to withdraw the amount

        // Set event handlers
        Button.setOnAction(event -> {
            int accountId = Integer.parseInt(idTextField.getText());
            Account account = getAccount(accountId);
            if (account != null) {//if else condition
                accountLabel.setText("Account ID: " + account.getId());
                balanceLabel.setText("Balance: $" + String.format("%.2f", account.getBalance()));
                dateCreatedLabel.setText("Date Created: " + account.getDateCreated().toString());
            } else {
                accountLabel.setText("Invalid Account ID");//display an error message for invalid account
                balanceLabel.setText("");//clear the balance label
                dateCreatedLabel.setText("");
            }
        });

        depositButton.setOnAction(event -> {
            int accountId = Integer.parseInt(idTextField.getText());
            Account account = getAccount(accountId);
            if (account != null) {
                double amount = Double.parseDouble(depositTextField.getText());
                account.deposit(amount);
                balanceLabel.setText("Balance: $" + String.format("%.2f", account.getBalance()));
            }
        });

        withdrawButton.setOnAction(event -> {
            int accountId = Integer.parseInt(idTextField.getText());
            Account account = getAccount(accountId);
            if (account != null) {
                double amount = Double.parseDouble(withdrawTextField.getText());
                if (amount <= account.getBalance()) {
                    account.withdraw(amount);
                    balanceLabel.setText("Balance: $" + String.format("%.2f", account.getBalance()));
                } else {
                    balanceLabel.setText("Insufficient funds");
                }
            }
        });


        VBox vbox = new VBox(10);//created a verticle box
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(idLabel, idTextField,Button, accountLabel, balanceLabel,
                dateCreatedLabel, depositLabel, depositTextField, depositButton, withdrawLabel,
                withdrawTextField, withdrawButton);


        Scene scene = new Scene(vbox);//create a scene with the vbox
        primaryStage.setTitle("ATM Machine");//title
        primaryStage.setScene(scene);
        primaryStage.show();//to display the title
    }

    private Account getAccount(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    private class Account {
        private int id;
        private double balance;
        private Date dateCreated;

        public Account(int id, double balance) {
            this.id = id;
            this.balance = balance;
            this.dateCreated = new Date();//Initialize the dateCreated field with the current date and time
        }

        public int getId() {
            return id;
        }

        public double getBalance() {
            return balance;
        }

        public Date getDateCreated() {
            return dateCreated;
        }

        public void deposit(double amount) {
            balance += amount;//increase the balance
        }

        public void withdraw(double amount) {
            balance -= amount;//decrease the balance
        }
    }
}