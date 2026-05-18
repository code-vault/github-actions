Feature: Login functionality

  @Smoke
  Scenario Outline:
    Given User is on loginPage
    When User enters username as "<username>" and password as "<password>"
    And User clicks login button
    Then User should see homepage

    Examples:
      | username          | password      |
      | standard_user     | secret_sauce  |
      | visual_user       | secret_sauce  |
