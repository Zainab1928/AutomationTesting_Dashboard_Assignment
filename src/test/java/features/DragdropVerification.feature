@DragAndDrop
Feature: Validate drag and drop functionality for the new table

  @testScenario1
  Scenario Outline: Validate column order after drag and drop in a new table
    Given User is logged in
    When User clicks on patient tab
    And User enters patient ID "da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9"
    And User clicks on the task tab
    When User drags the "<Source Column>" and drops it on "<Destination Column>"
    Then The new column index sequence should be:
      | Column         |
      | Name           |
      | Priority       |
      | Due Date       |
      | Status         |
      | Task           |
      | Phone          |
      | Note           |
      | Assigned To    |
      | Recipient Role |
      | Recipient Name |
      | Language       |
    Examples:
    | Source Column | Destination Column |
    | Due Date      | Status             |

  @testScenario2
  Scenario Outline: Validate list order after drag and drop in the new table
    Given User is logged in
    And User enters patient ID "da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9"
    And User clicks on the task tab
    When User drags the "<Source Column>" and drops it on "<Destination Column>"
    Then The new column index sequence in a list should be:
      | Column         |
      | Name           |
      | Priority       |
      | Status         |
      | Due Date       |
      | Task           |
      | Phone          |
      | Note           |
      | Assigned To    |
      | Recipient Role |
      | Recipient Name |
      | Language       |
    Examples:
      | Source Column | Destination Column |
      | Due Date      | Status             |

  @testScenario3
  Scenario Outline: Validate reset functionality in the new table
    Given User is logged in
    And User enters patient ID "da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9"
    And User clicks on the task tab
    When User drags the "<Source Column>" and drops it on "<Destination Column>"
    And User clicks on Reset Button
    Then The new column index sequence in a list should be:
      | Column         |
      | Due Date       |
      | Priority       |
      | Status         |
      | Task           |
      | Name           |
      | Phone          |
      | Note           |
      | Assigned To    |
      | Recipient Role |
      | Recipient Name |
      | Language       |
    Examples:
    | Source Column | Destination Column |
    | Due Date      | Status             |
