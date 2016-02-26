@screen
Feature: As a Customer I pay all my invoices

  Scenario: Pay e-on invoice
    Given I open url "https://myline-eon.ro/"
    And I type "user@gmail.com" into "Utilizator" field
    And I type "******" into "Parolă" field
    When I click on "Login" button
    Then I should see an element with text "PRENUME NUME"
    When I click on "Facturile mele" button
    And I click on link with text "Facturi gaze naturale"
    And I click on "Achită" button
    And I click on "Plăteşte" button
    Then I enter my SecureGW card details "4444333322221111"/"123" that expires on "01"/"2017" and owned by "PRENUME NUME"
    And I proceed to SecureGW payment
    And I type "3Dpassword" into BT 3DSecure password
    And I finalize payment on BT 3DSecure
    And I should see an element with text "Plata dumneavoastră a fost înregistrată cu success!"


  Scenario: Pay UPC invoice
    Given I open url "https://my.upc.ro/"
    And I type "user@gmail.com" into "E-mail:" field
    And I type "******" into "Parola My UPC:" field
    When I click on "Login" button
    Then I should see an element containing text "PRENUME NUME"
    When I click on link with text "Plata facturi"
    And I click on "Continua" button
    And I switch browser to last tab
    And I click on input button with text "Pasul următor"
    Then I enter my PayU card details "4444333322221111"/"123" that expires on "01 (Ianuarie)"/"2017" and owned by "PRENUME NUME"
    And I click on input button with text "Plateste"
    And I type "3Dpassword" into PayU password
    And I finalize payment on PayU site
    And I get a success notification from PayU

  Scenario: Pay DIGI invoice
    Given I open url "https://digicare.rcs-rds.ro/"
    And I login on DIGI using "user@gmail.com"/"******"
    Then I should see an element containing text "PRENUME NUME"
    When I open invoice list on DIGI
    Then I select to pay all invoices on DIGI
    And I enter my EuPlatesc card details "4444333322221111"/"123" that expires on "01 Ianuarie"/"2017" and owned by "PRENUME NUME"
    And I click on input button with text "Plăteşte online"
    And I type "3Dpassword" into BT 3DSecure password
    And I finalize payment on BT 3DSecure
    #And I get a success notification from PayU
      #Comanda dvs. a fost finalizată cu succes.
      #Mulţumim!!
    And I click on "Înapoi la site" button

  Scenario: Pay Electrica invoice
    Given I open url "https://oficiulvirtual.electricafurnizare.ro/"
    And I login on Electrica using "user"/"******"
    And I open invoice list on Electrica for place "1010111 - CLUJ, CLUJ-NAPOCA, Str. Testelor, nr.1, Bl.B1, Sc.1, Et.2, Ap.3, 12345"
    When I select to pay all invoices on Electrica
    And I enter my card details "4444333322221111"/"123" that expires on "01"/"2017" and owned by "PRENUME NUME" on MobilPay
    Then I proceed to MobilPay payment
    And I type "3Dpassword" into BT 3DSecure password
    And I finalize payment on BT 3DSecure
    And I should see an element containing text "Plata online este in curs de procesare. Va multumim!"
    And I click on link with text "OK"
    #And I click on link with text "Log-out"