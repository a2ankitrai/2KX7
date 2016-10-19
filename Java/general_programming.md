# General Programming

## **Minimize the scope of local variables**

**The most powerful technique for minimizing the scope of a local variable
is to declare it where it is first used**. If a variable is declared before it is used, it’s
just clutter—one more thing to distract the reader who is trying to figure out what
the program does. By the time the variable is used, the reader might not remember
the variable’s type or initial value.

## **Avoid float and double if exact answers are required**

The `float` and `double` types are designed primarily for scientific and engineering
calculations. They perform binary floating-point arithmetic, which was carefully
designed to furnish accurate approximations quickly over a broad range of magnitudes.
They do not, however, provide exact results and should not be used where
exact results are required. **The float and double types are particularly illsuited
for monetary calculations** because it is impossible to represent 0.1 (or any
other negative power of ten) as a `float` or `double` exactly.

The right way to solve this problem is to **use `BigDecimal`, `int`, or `long` for monetary calculations**.