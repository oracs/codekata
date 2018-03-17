package com.dy.kata.stringcompare.analyze.merge;

import com.dy.kata.stringcompare.model.SplitResult;
import com.dy.kata.stringcompare.model.SplitUnit;

import java.util.List;

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
                mergedContent += originalUnits.get(i + 1).content();
                mergedLength += originalUnits.get(i + 1).length();
                flag = true;
                continue;
            }
            if (flag) {
                mergedResult.add(new SplitUnit(
                        originalUnits.get(i).type(),
                        mergedContent,
                        mergedLength));

                System.out.println("else new: " + mergedContent);
                flag = false;
            } else {
                mergedResult.add(originalUnits.get(i));
                System.out.println("differ: " + originalUnits.get(i).content());
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
            System.out.println("last same:" + mergedContent);
        }
//            else {
//                mergedResult.add(originalUnits.get(size - 1));
//                System.out.println("last differ:" + originalUnits.get(size - 1).content());
//            }

        return mergedResult;
    }
}
