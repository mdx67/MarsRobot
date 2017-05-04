<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  	        <div class="form-group">
          <label for="x">x</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='x' type='text'/>
<form:errors path='x'/>

          </div>
        </div>
        <div class="form-group">
          <label for="y">y</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='y' type='text'/>
<form:errors path='y'/>

          </div>
        </div>
        <div class="form-group">
          <label for="direction">direction</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='direction' type='text'/>
<form:errors path='direction'/>

          </div>
        </div>
