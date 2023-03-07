Feature: Check all given credentials are valid

  @smoke @credentials
  Scenario Outline: Check Login and Password
    Given User is on the home page
    When user enters "<login>" and "<password>" in range of <start> to <end>
    Examples:
      | login        | password     | start | end |
      | salesmanager | salesmanager | 5     | 105 |
      | posmanager   | posmanager   | 15    | 155 |







  #Login pattern salesmanager+range+@info.com password: salesmanager
  #Login pattern posmanager+range+@info.com   password: posmanager
  #salesmanager range = 5-105
  #posmanager        = 5-155


    #to beautify the pipes above
    #mac: command + option + L
    #windows: control + alt + L