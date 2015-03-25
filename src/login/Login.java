/*
 * Copyright (c) 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Cadastro de Aluno");
        scenetitle.setId("welcome-text");
        
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("RA:");
        grid.add(userName, 0, 1);
       
              
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label nome = new Label("Nome:");
        grid.add(nome, 0, 2);
        TextField userNome = new TextField();
        grid.add(userNome,1,2);
        //PasswordField pwBox = new PasswordField();
        //grid.add(pwBox, 1, 2);
        
        Label sexo = new Label("Sexo:");
        grid.add(sexo, 0, 3);
        
        HBox hbSex = new HBox(2);
        grid.add(hbSex, 1, 3);
        RadioButton rb = new RadioButton();
        rb.setText("Masculino");
        hbSex.getChildren().add(rb);
        
        RadioButton rb2 = new RadioButton();
        rb2.setText("Feminino");
        hbSex.getChildren().add(rb2);
        
        Label estado = new Label("Estado:");
        grid.add(estado, 0, 4);
        
        ComboBox cb = new ComboBox();
        
        cb.getItems().addAll(
            "MS",
            "SP",
            "RJ",
            "AL"
        );
        grid.add(cb,1,4);
        cb.setVisibleRowCount(3);
        Button btn = new Button("Salvar");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);
        
       Button btl = new Button("Limpar");
       hbBtn.getChildren().add(btl);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setId("actiontarget");
                actiontarget.setText("Aluno Cadastrado com sucesso!!");
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add
        (Login.class.getResource("Login.css").toExternalForm());
        primaryStage.show();
    }
}