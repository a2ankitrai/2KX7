# Angular-JS
---

## What is scope, rootscope?

Scope is an object that refers to the application model. It is an execution context for expressions. Scopes are arranged in hierarchical structure which mimic the DOM structure of the application. Scopes can watch expressions and propagate events.
	
**Scope characteristics**
- Scopes provide APIs (`$watch`) to observe model mutations.

- Scopes provide APIs (`$apply`) to propagate any model changes through the system into the view from outside of the "Angular realm" (controllers, services, Angular event handlers).

- Scopes can be nested to limit access to the properties of application components while providing access to shared model properties. Nested scopes are either "child scopes" or "isolate scopes". A "child scope" (prototypically) inherits properties from its parent scope. An "isolate scope" does not. 
	
Every application has a single root scope. All other scopes are descendant scopes of the root scope. Scopes provide separation between the model and the view, via a mechanism for watching the model for changes. They also provide event emission/broadcast and subscription facility. 

---

- Difference between controllers, services and factories?

- directives?
	
	Directives are markers on a DOM element (such as an attribute, element name, comment or CSS class) that tell AngularJS’s HTML compiler ($compile) to attach a specified behavior to that DOM element (e.g. via event listeners), or even to transform the DOM element and its children.

- app.config module

---

## Routing, States and stateProvider?

### the difference between $routeProvider and $stateProvider?

**Angular Routing - per $routeProvider docs**

URLs to controllers and views (HTML partials). It watches $location.url() and tries to map the path to an existing route definition.

Limitations:-

- The page can only contain single ng-view on page

- If your SPA has multiple small components on page which you wanted to render based on some condition, In such scenario $routeProvider fails.(for achieving the same we need to go for directive like ng-include, ng-switch, ng-if, ng-show actually which looks bad to have them in SPA)

- You can not relate between two routes like parent and child relationship.

- You cannot show and hide a part view based on url pattern.


**ui-router - per $stateProvider docs**

AngularUI Router is a routing framework for AngularJS, which allows you to organize the parts of your interface into a state machine. UI-Router is organized around states, which may optionally have routes, as well as other behavior, attached.

States are bound to named, nested and parallel views, allowing you to powerfully manage your application's interface.

**Multiple & Named Views**

- Another great feature is the ability to have multiple ui-views view per template.

- While multiple parallel views are a powerful feature, you'll often be able to manage your interfaces more effectively by nesting your views, and pairing those views with nested states.

**Pros**

- You can have multiple ui-view on single page.

- Various view can be nested in each other and maintain by defining state in routing phase.

---

- Difference between angular 1 & 2?

- Promises

---

## $compile

Compiles an HTML string or DOM into a template and produces a template function, which can then be used to link scope and the template together.

---

## Questions

- How do you share data between controllers?
	
	Create an AngularJS service that will hold the data and inject it inside of the controllers.

- What is the difference between ng-show/ng-hide and ng-if directives?

	`ng-show/ng-hide` will always insert the DOM element, but will display/hide it based on the condition. `ng-if` will not insert the DOM element until the condition is not fulfilled. `ng-if` is better when we needed the DOM to be loaded conditionally, as it will help load page bit faster compared to `ng-show/ng-hide`.

- digest cycle in AngularJS.

	In each digest cycle Angular compares the old and the new version of the scope model values. The digest cycle is triggered automatically. We can also use `$apply()` if we want to trigger the digest cycle manually.
	
	[Digest loop and apply](https://www.ng-book.com/p/The-Digest-Loop-and-apply/)

-  how $scope.$apply() works

	`$scope.$apply` re-evaluates all the declared ng-models and applies the change to any that have been altered (i.e. assigned to a new value).

	