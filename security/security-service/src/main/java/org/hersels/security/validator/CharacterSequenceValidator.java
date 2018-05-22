package org.hersels.security.validator;

import org.apache.commons.lang3.StringUtils;
import org.hersels.common.api.IPasswordValidator;
import org.springframework.stereotype.Component;

@Component
public class CharacterSequenceValidator implements IPasswordValidator {

    @Override
    public boolean validate(String text) {
        // null matches the validation
        if (StringUtils.isEmpty(text)) return true;
        if (text.length() > 1 && StringUtils.isAllBlank(text)) return false;
        int maxSequenceLength = text.length() / 2;

        for (int seqLength = 1; seqLength <= maxSequenceLength; seqLength++) {
            for (int seqPosition = 0; seqPosition <= text.length() - (seqLength * 2); seqPosition++) {
                String seq = text.substring(seqPosition, seqPosition + seqLength);
                String compareSeq = text.substring((seqLength + seqPosition), (seqLength + seqPosition + seqLength));
                if (StringUtils.equals(seq, compareSeq)) return false;
            }
        }

        return true;
    }
}
