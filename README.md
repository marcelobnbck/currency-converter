# Currency Converter

A simple Java command-line application that converts between USD (US Dollar) and BRL (Brazilian Real) using real-time exchange rates from the ExchangeRate-API.

## Features

- Real-time currency conversion between USD and BRL
- Simple command-line interface
- Error handling for invalid inputs
- Uses ExchangeRate-API for up-to-date exchange rates

## Prerequisites

- Java JDK 17 or later
- Maven (for dependency management)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/currency-converter.git
   cd currency-converter

2. Build the project with Maven:
    ```bash
    mvn clean package

## Project Structure
- ValueConsult.java: Handles API requests and response parsing
- CurrencyConverter.java: Main application with user interface
- ExchangeRateApi.java: Data model for exchange rate information

## Dependencies
- Gson - For JSON parsing
- Java 11+ HTTP Client - For API requests

## API Key
The application uses a free-tier API key from ExchangeRate-API.