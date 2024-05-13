import { Link } from "react-router-dom";
import { Button } from "@mantine/core";
import { IconMessageCircle } from "@tabler/icons-react";

function ButtonComment({ children, path }) {
    return (
        <Button 
            component={Link} 
            to={path}
            color="gray"
            variant="subtle"
            leftSection={<IconMessageCircle size={20}/>}
        >
            {children}
        </Button>
    );
}

export default ButtonComment;