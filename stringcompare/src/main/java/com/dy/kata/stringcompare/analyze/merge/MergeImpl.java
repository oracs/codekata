package com.dy.kata.stringcompare.analyze.merge;

import com.dy.kata.stringcompare.model.SplitResult;
import com.dy.kata.stringcompare.model.SplitUnit;

import java.util.List;

import static com.dy.kata.stringcompare.model.ResultType.letter;

public class MergeImpl implements Merger {
    @Override
    public SplitResult merge(SplitResult input) {
        List<SplitUnit> originalUnits = input.getSplitUnits();
        SplitResult mergedResult = new SplitResult();

        String mergedContent = originalUnits.get(0).content();
        int mergedLength = originalUnits.get(0).length();
        int size = originalUnits.size();
        boolean flag = false;

        // todo maybe perfermance issure.
        for (int i = 0; i < size; i++) {
            if (((i + 1) < size) && originalUnits.get(i).type() == originalUnits.get(i + 1).type()) {
                if (originalUnits.get(i).type() == letter) {
                    mergedContent += originalUnits.get(i + 1).content();
                } else {
                    // todo xxx
                    mergedContent += ","+originalUnits.get(i + 1).content();
                }
                mergedLength += originalUnits.get(i + 1).length();
                flag = true;
                continue;
            }
            if (flag) {
                String newContents = (originalUnits.get(i).type() == letter)
                        ? mergedContent
                        : makeNewDigits(mergedContent);

                mergedResult.add(new SplitUnit(
                        originalUnits.get(i).type(),
                        newContents,
                        mergedLength));

//                System.out.println("else new " + originalUnits.get(i).type() + ": " + newContents);
                flag = false;
            } else {
                mergedResult.add(originalUnits.get(i));
//                System.out.println("differ: " + originalUnits.get(i).content());
            }

            if ((i + 1) < size) {
                mergedContent = originalUnits.get(i + 1).content();
                mergedLength = originalUnits.get(i + 1).length();
            }
        }

        if (flag) {
            mergedResult.add(new SplitUnit(
                    originalUnits.get(size - 1).type(),
                    mergedContent,
                    mergedLength));
//            System.out.println("last same:" + mergedContent);
        }

        return mergedResult;
    }

    //  123,65 -> 123*10 + 65
    private String makeNewDigits(String mergedContent) {
        String[] splitstr = mergedContent.split(",");
        int sum = 0;
        for (int i = 0; i < splitstr.length; i++) {
            sum += calcMultiplier(splitstr[i], (splitstr.length - i - 1));
        }

        return String.valueOf(sum);
    }

    private int calcMultiplier(String value, int n) {
        int result = Integer.valueOf(value);
        if (n == 0) return result;

        for (int i = 0; i < n; i++) {
            result = result * 10;
        }

        return result;
    }
}
