# MyNavDrawerApp
This is an android app built to display the Most Popular Articles of The NY Times and show the list of articles.

## Application Features
- Navigation Drawer layout with menu
- Listing page of most popular articles of The Newyork Times
- Details Page on clicking the listing
- Static search page(Functionality can be added in future)

## Architecture
This is built based on MVP with clean architecture. In this, every layer to have its own model that it works with, so the concrete details, such as views, do not depend on the specific details of the lower layer implementations.

## UI/ Presenter Layer

The Presenter depends on the View interface and not directly on the Activity. We can replace the concrete view without changing a line of code of the presenter. Furthermore, we can easily unit-test presenter by creating a mock view.
**Contract** package holds the class which contains interfaces PopularArticlesView and PopularArticlePresenter and thus act as a contract between view and presenter.

## Business Layer

**Use Case** is a reusable component that executes a specific business logic. It fetches the data from a repository, executes the business logic and returns the result to the presenter. As there is no business logic to be processed here, it just delegate the call to repo.

## Data Layer (API)

Repository Pattern is responsible to create an abstraction of the data sources from which the Use Cases get the data to act upon. 
API : https://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=my_key

## Technologies 
- MVP architecture
- RxJava2
- Dagger
- ButterKnife

## How to run
clone gitlab project to android studio. Compile and run.

## Testability
All domain code is tested with unit tests. Presenter, Resository and Usecases are covered.

## Coverage Reports
Coverage reports are generated using jacoco plugin and added to the folder /build/reports/tests/testDebugUnitTest
