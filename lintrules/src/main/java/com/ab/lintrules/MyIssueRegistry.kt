package com.ab.lintrules

import com.ab.lintrules.importrules.ISSUE_IMPORT_DETECTOR
import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue

class MyIssueRegistry : IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(
            ISSUE_IMPORT_DETECTOR
        )
}
