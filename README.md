Talks Samples
=============

Project Lambda
--------------
* Contexts for target typing
* Default and static interface methods
* Lambda Conversion
* Lambda expressions and closures
* Lexical scoping
* Variable capture
* Stream API
    * tests for lazyness and eagerness

Functional Programming
----------------------
* SML:
    * pattern matching
* Scala:
    * recursion
    * tail recursion
    * higher order functions
    * currying

JSON Processing review
----------------------
* API shortcommings
    * inconsistent method naming
    * JsonValue.NULL vs null literal mismatch
    * misleading toString() for JsonValue.NULL
    * misleading toString() for JsonValue.TRUE and JsonValue.FALSE
* Proposals
    * JsonFeature usage
    * changes in the hashCode() and equals() for JsonNumberImpl
* Unit tests
    * JsonObject.equals() behavior