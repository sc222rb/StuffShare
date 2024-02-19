# StuffShare

StuffShare is a console-based lending system designed to facilitate the borrowing and lending of various items within a community. The system promotes sustainability by encouraging members to share resources rather than purchasing new items unnecessarily.

## Features

- **Member Management:** Create, update, and delete member profiles with unique identifiers, email addresses, and mobile phone numbers.
- **Item Listing:** Add, modify, and remove items available for lending, including categorization, descriptions, and lending costs.
- **Contract Establishment:** Create lending contracts specifying the start and end dates for item borrowing, with credits transferred accordingly.
- **Time Management:** Advance the system's internal day counter for testing purposes.
- **Persistence Interface:** Prepare for future implementation of persistence by adding a persistence interface.
- **Hard-Coded Data:** Initialize the system with hard-coded member and item data for testing purposes.

## Installation

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Run `./gradlew build` to build the project.
4. Run `./gradlew run -q --console=plain` to execute the application.

## Usage

- Upon running the application, navigate the menu using options.
- Follow the prompts to perform various actions such as creating members, adding items, establishing contracts, and advancing time.
- Use the menu options to interact with the system's functionalities.
