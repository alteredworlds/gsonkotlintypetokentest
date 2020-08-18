# Gson Kotlin TypeToken test
Demonstrates a change in behaviour between Kotlin 1.3.72 and 1.4.0

Identical test code passes wtih 1.3.72 and fails with 1.4.0

Code was taken from a Room @TypeConverter in a current project.

See `androidTest/GsonArrayListFromJsonTest`

On branch `master`, all runs fine - configured using Kotlin 1.3.72

On branch `kotlin_1_4_0` test `testGsonArrayListFromJsonTest()` fails with an exception
