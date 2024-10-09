$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/DragdropVerification.feature");
formatter.feature({
  "name": "Validate drag and drop functionality for the new table",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@DragAndDrop"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Validate column order after drag and drop in a new table",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@testScenario1"
    }
  ]
});
formatter.step({
  "name": "User is logged in",
  "keyword": "Given "
});
formatter.step({
  "name": "User clicks on patient tab",
  "keyword": "When "
});
formatter.step({
  "name": "User enters patient ID \"da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9\"",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks on the task tab",
  "keyword": "And "
});
formatter.step({
  "name": "User drags the \"\u003cSource Column\u003e\" and drops it on \"\u003cDestination Column\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "The new column index sequence should be:",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "Column"
      ]
    },
    {
      "cells": [
        "Priority"
      ]
    },
    {
      "cells": [
        "Status"
      ]
    },
    {
      "cells": [
        "Due Date"
      ]
    },
    {
      "cells": [
        "Task"
      ]
    },
    {
      "cells": [
        "Name"
      ]
    },
    {
      "cells": [
        "Phone"
      ]
    },
    {
      "cells": [
        "Note"
      ]
    },
    {
      "cells": [
        "Assigned To"
      ]
    },
    {
      "cells": [
        "Recipient Role"
      ]
    },
    {
      "cells": [
        "Recipient Name"
      ]
    },
    {
      "cells": [
        "Language"
      ]
    },
    {
      "cells": [
        "GNR Date (Adh)"
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
        "Source Column",
        "Destination Column"
      ]
    },
    {
      "cells": [
        "Due Date",
        "Status"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Validate column order after drag and drop in a new table",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@DragAndDrop"
    },
    {
      "name": "@testScenario1"
    }
  ]
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
  "name": "User is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "DragDropStep.user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on patient tab",
  "keyword": "When "
});
formatter.match({
  "location": "DragDropStep.user_click_patient_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters patient ID \"da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9\"",
  "keyword": "And "
});
formatter.match({
  "location": "PatientStep.user_enters_the_patient_id(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the task tab",
  "keyword": "And "
});
formatter.match({
  "location": "DragDropStep.user_clicks_on_the_task_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User drags the \"Due Date\" and drops it on \"Status\"",
  "keyword": "When "
});
formatter.match({
  "location": "DragDropStep.user_drags_the_and_drops_it_on(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The new column index sequence should be:",
  "rows": [
    {
      "cells": [
        "Column"
      ]
    },
    {
      "cells": [
        "Priority"
      ]
    },
    {
      "cells": [
        "Status"
      ]
    },
    {
      "cells": [
        "Due Date"
      ]
    },
    {
      "cells": [
        "Task"
      ]
    },
    {
      "cells": [
        "Name"
      ]
    },
    {
      "cells": [
        "Phone"
      ]
    },
    {
      "cells": [
        "Note"
      ]
    },
    {
      "cells": [
        "Assigned To"
      ]
    },
    {
      "cells": [
        "Recipient Role"
      ]
    },
    {
      "cells": [
        "Recipient Name"
      ]
    },
    {
      "cells": [
        "Language"
      ]
    },
    {
      "cells": [
        "GNR Date (Adh)"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DragDropStep.the_new_column_index_sequence_should_be(DataTable)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: The column sequence is incorrect after drag and drop.: lists don\u0027t have the same size expected [12] but found [11]\r\n\tat org.testng.Assert.fail(Assert.java:99)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:1037)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:140)\r\n\tat org.testng.Assert.assertEquals(Assert.java:122)\r\n\tat org.testng.Assert.assertEquals(Assert.java:907)\r\n\tat org.testng.Assert.assertEquals(Assert.java:1089)\r\n\tat pages.DragDropPage.validateColumns(DragDropPage.java:125)\r\n\tat StepDefinition.DragDropStep.the_new_column_index_sequence_should_be(DragDropStep.java:70)\r\n\tat ✽.The new column index sequence should be:(src/test/java/features/DragdropVerification.feature:11)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});