package Employee;

import Department.*;

public enum Role {
    HR(Position.HR_ASSISTANT, Position.HR_MANAGER),
    MARKETING(Position.MARKETING_ASSISTANT, Position.MARKETING_MANAGER),
    DEVELOPER(Position.JUNIOR_DEVELOPER, Position.SENIOR_DEVELOPER);

    private final Position[] positions;

    Role(Position... positions) {
        this.positions = positions.clone(); // make defensive copy
    }

    public Position[] getPositions() {
        return positions.clone(); // make defensive copy
    }

    public enum Position {
        HR_ASSISTANT,
        HR_MANAGER,
        MARKETING_ASSISTANT,
        MARKETING_MANAGER,
        JUNIOR_DEVELOPER,
        SENIOR_DEVELOPER
    }
}