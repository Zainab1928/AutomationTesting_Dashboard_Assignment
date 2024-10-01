$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/Patient-Information-Verification.feature");
formatter.feature({
  "name": "ETL Patient Information Verification",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verify patient information for multiple patients",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "click on patient tab",
  "keyword": "When "
});
formatter.step({
  "name": "search patient: \"\u003cPatientId\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "user verifies the patient details from patient info with provided info:",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "Field",
        "Value"
      ]
    },
    {
      "cells": [
        "FirstName",
        "\u003cFirstName\u003e"
      ]
    },
    {
      "cells": [
        "LastName",
        "\u003cLastName\u003e"
      ]
    },
    {
      "cells": [
        "DOB",
        "\u003cDOB\u003e"
      ]
    },
    {
      "cells": [
        "Address1",
        "\u003cAddress1\u003e"
      ]
    },
    {
      "cells": [
        "Address2",
        "\u003cAddress2\u003e"
      ]
    },
    {
      "cells": [
        "PreferredPhone",
        "\u003cPreferredPhone\u003e"
      ]
    },
    {
      "cells": [
        "Email",
        "\u003cEmail\u003e"
      ]
    },
    {
      "cells": [
        "ZipCode",
        "\u003cZipCode\u003e"
      ]
    },
    {
      "cells": [
        "City",
        "\u003cCity\u003e"
      ]
    },
    {
      "cells": [
        "Sex",
        "\u003cSex\u003e"
      ]
    }
  ]
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "PatientId",
        "FirstName",
        "LastName",
        "DOB",
        "Address1",
        "Address2",
        "PreferredPhone",
        "Email",
        "ZipCode",
        "City",
        "Sex"
      ]
    },
    {
      "cells": [
        "da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9",
        "Hardstop",
        "Select health test patient 1",
        "01/01/1965",
        "100 Test Drive",
        "",
        "111-111-1111",
        "",
        "99999",
        "Test City",
        "female"
      ]
    },
    {
      "cells": [
        "a89a0a0c-4202-4b64-949a-5e48c16d1aea",
        "Select concierge test patient 8",
        "Hardstop",
        "01/01/1965",
        "100 Test Drive",
        "",
        "111-111-1111",
        "",
        "99999",
        "Test City",
        "female"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify patient information for multiple patients",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "click on patient tab",
  "keyword": "When "
});
formatter.match({
  "location": "PatientInformationVerificationStep.click_on_patient_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "search patient: \"da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9\"",
  "keyword": "And "
});
formatter.match({
  "location": "PatientInformationVerificationStep.search_patient(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies the patient details from patient info with provided info:",
  "rows": [
    {
      "cells": [
        "Field",
        "Value"
      ]
    },
    {
      "cells": [
        "FirstName",
        "Hardstop"
      ]
    },
    {
      "cells": [
        "LastName",
        "Select health test patient 1"
      ]
    },
    {
      "cells": [
        "DOB",
        "01/01/1965"
      ]
    },
    {
      "cells": [
        "Address1",
        "100 Test Drive"
      ]
    },
    {
      "cells": [
        "Address2",
        ""
      ]
    },
    {
      "cells": [
        "PreferredPhone",
        "111-111-1111"
      ]
    },
    {
      "cells": [
        "Email",
        ""
      ]
    },
    {
      "cells": [
        "ZipCode",
        "99999"
      ]
    },
    {
      "cells": [
        "City",
        "Test City"
      ]
    },
    {
      "cells": [
        "Sex",
        "female"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "PatientInformationVerificationStep.user_verifies_patient_details(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify patient information for multiple patients",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "click on patient tab",
  "keyword": "When "
});
formatter.match({
  "location": "PatientInformationVerificationStep.click_on_patient_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "search patient: \"a89a0a0c-4202-4b64-949a-5e48c16d1aea\"",
  "keyword": "And "
});
formatter.match({
  "location": "PatientInformationVerificationStep.search_patient(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies the patient details from patient info with provided info:",
  "rows": [
    {
      "cells": [
        "Field",
        "Value"
      ]
    },
    {
      "cells": [
        "FirstName",
        "Select concierge test patient 8"
      ]
    },
    {
      "cells": [
        "LastName",
        "Hardstop"
      ]
    },
    {
      "cells": [
        "DOB",
        "01/01/1965"
      ]
    },
    {
      "cells": [
        "Address1",
        "100 Test Drive"
      ]
    },
    {
      "cells": [
        "Address2",
        ""
      ]
    },
    {
      "cells": [
        "PreferredPhone",
        "111-111-1111"
      ]
    },
    {
      "cells": [
        "Email",
        ""
      ]
    },
    {
      "cells": [
        "ZipCode",
        "99999"
      ]
    },
    {
      "cells": [
        "City",
        "Test City"
      ]
    },
    {
      "cells": [
        "Sex",
        "female"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "PatientInformationVerificationStep.user_verifies_patient_details(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});