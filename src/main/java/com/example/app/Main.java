package com.example.app;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {

        HttpServer server =
                HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {

            String html = """
                    <!DOCTYPE html>
                    <html>

                    <head>
                        <title>Simple Calculator</title>

                        <style>

                            body {
                                font-family: Arial;
                                text-align: center;
                                margin-top: 50px;
                            }

                            input {
                                padding: 10px;
                                margin: 5px;
                            }

                            button {
                                padding: 10px 20px;
                                margin: 5px;
                                cursor: pointer;
                            }

                            #result {
                                margin-top: 20px;
                                font-size: 20px;
                                font-weight: bold;
                            }

                        </style>

                    </head>

                    <body>

                        <h1>Simple Calculator</h1>

                        <input
                            type="number"
                            id="num1"
                            placeholder="Number 1"
                        >

                        <input
                            type="number"
                            id="num2"
                            placeholder="Number 2"
                        >

                        <br><br>

                        <button onclick="calculate('add')">
                            Add
                        </button>

                        <button onclick="calculate('subtract')">
                            Subtract
                        </button>

                        <button onclick="calculate('multiply')">
                            Multiply
                        </button>

                        <div id="result">
                            Result: 
                        </div>


                        <script>

                            function calculate(operation) {

                                let num1 =
                                    Number(document.getElementById("num1").value);

                                let num2 =
                                    Number(document.getElementById("num2").value);

                                let result;


                                if (operation === "add") {

                                    result = num1 + num2;

                                }

                                else if (operation === "subtract") {

                                    result = num1 - num2;

                                }

                                else if (operation === "multiply") {

                                    result = num1 * num2;

                                }


                                document.getElementById("result").innerHTML =
                                    "Result: " + result;
                            }

                        </script>

                    </body>

                    </html>
                    """;

            exchange.getResponseHeaders()
                    .set("Content-Type", "text/html");

            byte[] response =
                    html.getBytes(StandardCharsets.UTF_8);

            exchange.sendResponseHeaders(
                    200,
                    response.length
            );

            OutputStream output =
                    exchange.getResponseBody();

            output.write(response);

            output.close();
        });

        server.start();

        System.out.println(
                "Server started at http://localhost:8080"
        );
    }
}



// set PATH=%PATH%;C:\Program Files\Apache\maven\bin
// java -cp target\classes com.example.app.Main
