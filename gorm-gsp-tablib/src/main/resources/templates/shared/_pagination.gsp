<div class="pagination">
    <g:if test="${pages > 1 && currentPage > 1}">
        <a href="${action}/${currentPage - 1}" class="prevLink">Previous</a>
    </g:if>
    <g:each in="${1..pages}" var="page">
        <g:if test="${page==currentPage}">
            <span class="currentStep">${page}</span>
        </g:if>
        <g:else>
            <a href="${action}/${page}" class="step">${page}</a>
        </g:else>
    </g:each>
    <g:if test="${pages > 1 && currentPage < pages}">
        <a href="${action}/${currentPage + 1}" class="nextLink">Next</a>
    </g:if>
</div>