Feature: ETL Patient Information Verification

  Scenario Outline: Verify patient information for multiple patients
    When click on patient tab
    And user enters patient id <PatientId>
    Then user verifies patient details
      | Field             | Value               |
      | FirstName         | <FirstName>         |
      | LastName          | <LastName>          |
      | DOB               | <DOB>               |
      | Address1          | <Address1>          |
      | Address2          | <Address2>          |
      | PreferredPhone    | <PreferredPhone>    |
      | Email             | <Email>             |
      | ZipCode           | <ZipCode>           |
      | City              | <City>              |
      | Sex               | <Sex>               |

    Examples:
      | PatientId                            | FirstName                       | LastName                     | DOB        | Address1       | Address2 | PreferredPhone | Email | ZipCode | City      | Sex    |
      | da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9 | Hardstop                        | Select health test patient 1 | 01/01/1965 | 100 Test Drive |          | 111-111-1111   |       | 99999   | Test City | female |
      | a89a0a0c-4202-4b64-949a-5e48c16d1aea | Select concierge test patient 8 | Hardstop                     | 01/01/1965 | 100 Test Drive |          | 111-111-1111   |       | 99999   | Test City | female |