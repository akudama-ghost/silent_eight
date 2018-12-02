Feature: ABC Feature

 Scenario: Open browser and go to test start page
   Given Open browser and go to "http://www.google.pl"
   When search for "elo"
   Then check if results are as expected