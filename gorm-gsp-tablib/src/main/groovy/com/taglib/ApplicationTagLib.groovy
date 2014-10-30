package com.taglib

import grails.gsp.TagLib
import org.springframework.stereotype.Component

@TagLib
@Component
class ApplicationTagLib {
    static namespace = "app"

    def eligibleForVoting = { attrs ->
        Integer age = attrs.int('age')
        out << (age > 18 ? 'Yes' : 'No')
    }

    def paginate = { attrs ->
        String action = attrs.action
        Integer total = attrs.total
        Integer currentPage = attrs.currentPage ?: 1

        Integer pages = (total / 10) + 1
        out << render(template: '/shared/pagination', model: [action: action, total: total, currentPage: currentPage, pages: pages])
    }
}
